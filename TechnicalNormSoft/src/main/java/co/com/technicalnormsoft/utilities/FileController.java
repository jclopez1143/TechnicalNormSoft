package co.com.technicalnormsoft.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.control.DatoObjetivoLogic;

@Scope("singleton")
@Service("uploadController")
public class FileController implements IFileController {

	private static final Logger log = LoggerFactory.getLogger(DatoObjetivoLogic.class);
	private String destination = "";

	//Method returns file array from EstablecimientoObjetivo directory
	public File[] getDirectoryFiles(EstablecimientoObjetivo establecimientoObjetivo) 
			throws Exception {
		File file = new File("/objetivo_file_content/"
				+ establecimientoObjetivo.getEstablecimientoObjetivoId());

		if (file.exists() && file.isDirectory()) {
			return file.listFiles();
		}
		return new File[0];
	}

	//Deletes file
	public boolean deleteObjetivoFile(File file) throws Exception {
		if (file.exists() && !file.isDirectory()) {
			return file.delete();
		}
		return false;
	}
	
	//Deletes all EstablecimientoObjetivos's file
	public void deleteAllObjetivoFile(EstablecimientoObjetivo establecimientoObjetivo) throws Exception {
		destination = getObjetivoFilePath(establecimientoObjetivo);
		if (destination != "") {
			File[] files = getDirectoryFiles(establecimientoObjetivo);
			for (File file : files) {
				deleteObjetivoFile(file);
			}
		}
	}
	
	//Method uploads file to EstablecimientoObjetivo directory.
	public void upload(FileUploadEvent event, EstablecimientoObjetivo establecimientoObjetivo) 
			throws Exception {
		destination = getObjetivoFilePath(establecimientoObjetivo);
		if (destination == "") {
			throw new Exception("Such file or directory does not exist.");
		}
		copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
	}

	//Method allows download file as StreamedContent
	public StreamedContent download(File file) throws Exception {
		String mimeType = "";

		if (file.getName().endsWith("gif")) {
			mimeType = "image/gif";
		} else if (file.getName().endsWith("jpg")) {
			mimeType = "image/jpg";
		} else if (file.getName().endsWith("png")) {
			mimeType = "image/png";
		} else if (file.getName().endsWith("docx")) {
			mimeType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		} else if (file.getName().endsWith("xlsx")) {
			mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		} else if (file.getName().endsWith("xls")) {
			mimeType = "application/vnd.ms-excel";
		} else if (file.getName().endsWith("pdf")) {
			mimeType = "application/pdf";
		}

		try {
			return new DefaultStreamedContent(new FileInputStream(file), mimeType, file.getName());
		} catch (Exception e) {
			throw new Exception("Error al descargar archivo.");
		}
	}

	//Method creates file in storage.
	public void copyFile(String fileName, InputStream in) throws Exception {
		try {

			OutputStream out = new FileOutputStream(new File(destination + "/" + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			log.info("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	//Method returns directory to upload; if do not exist, create by EstablecimientoObjetivo Id
	public String getObjetivoFilePath (EstablecimientoObjetivo establecimientoObjetivo) {
		File objetivo_file_content = new File("/objetivo_file_content/"
				+ establecimientoObjetivo.getEstablecimientoObjetivoId());

		if (objetivo_file_content.exists()) {
			return objetivo_file_content.getPath();
		} else {
			File newDirectory = new File("/objetivo_file_content/"
					+ establecimientoObjetivo.getEstablecimientoObjetivoId().toString());
			newDirectory.mkdir();

			return newDirectory.getPath();
		}
	}
}
