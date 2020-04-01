package co.com.technicalnormsoft.utilities;

import java.io.File;
import java.io.InputStream;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;

import co.com.technicalnormsoft.model.EstablecimientoObjetivo;

public interface IFileController {

	public void upload(FileUploadEvent event, EstablecimientoObjetivo establecimientoObjetivo) throws Exception;
	
	public void copyFile(String fileName, InputStream in) throws Exception;
	
	public File[] getDirectoryFiles(EstablecimientoObjetivo establecimientoObjetivo) throws Exception;
	
	public boolean deleteObjetivoFile(File file) throws Exception;
	
	public StreamedContent download(File file) throws Exception;
	
	public void deleteAllObjetivoFile(EstablecimientoObjetivo establecimientoObjetivo) throws Exception;
}
