package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;
import co.com.technicalnormsoft.model.dto.NormaDTO;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.*;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author Silicon Cali
 * 
 */
@ManagedBean
@ViewScoped
public class ObjetivoAutoevaluacionDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ObjetivoAutoevaluacionDetailsView.class);
	private Requisito requisito;
	private String numeralProyecto;
	private ObjetivoDTO selectedObjetivo;
	private DatoObjetivoDTO selectedDatoObjetivo;
	private ProyectoEstablecimientoDTO selectedProyectoEstablecimiento;
	private EstadoProyecto estadoProyecto;
	private NormaDTO selectedNorma;
	private EstadoObjetivo estadoObjetivo;
	private EstablecimientoObjetivo establecimientoObjetivo;
	private DatoObjetivo datoAutoevaluacion;
	private List<ValorDato> valorAutoevaluacion;
	private File[] loadedFiles;
	private boolean showDialog;
	private String txtEstado;
	private String txtNuevoEstadoObjetivo;
	private String txtObjetivoResolucion;
	private StreamedContent download;
	private CommandButton btnSave;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private HttpSession httpSession;

	public ObjetivoAutoevaluacionDetailsView() {
		super();
	}

	@PostConstruct
	public void init() {
		try {
			httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			action_set_details();
		} catch (Exception e) {
		}
	}

	@PreDestroy
	public void out() {
		try {
			action_clear_objetivo_data();
			if(establecimientoObjetivo != null) {
				if (loadedFiles.length == 0 && txtEstado.equals("Cumple Req.")) {
					txtNuevoEstadoObjetivo = "No Iniciado";
					update_establecimiento_objetivo();
				}

				if (txtObjetivoResolucion.equals("") && txtEstado.equals("No Aplica")) {
					txtNuevoEstadoObjetivo = "No Iniciado";
					update_establecimiento_objetivo();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String action_clear_objetivo_data() {
		try {
			if (establecimientoObjetivo != null) {
				if (loadedFiles.length > 0 && !txtEstado.equals("Cumple Req.")) {
					businessDelegatorView.deleteAllObjetivoFile(establecimientoObjetivo);
					loadedFiles = new File[0];
				}

				if (establecimientoObjetivo.getResolucion() == null && !txtEstado.equals("No Aplica")) {
					txtObjetivoResolucion = "";
				} else {
					txtObjetivoResolucion = establecimientoObjetivo.getResolucion();
				}
			} else {
				txtObjetivoResolucion = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void action_set_resolucion_data() {
		if (establecimientoObjetivo != null) {
			if (establecimientoObjetivo.getResolucion() != null && txtEstado.equals("No Aplica")) {
				if (!txtObjetivoResolucion.equals(establecimientoObjetivo.getResolucion())) {
					btnSave.setDisabled(false);
				} else {
					btnSave.setDisabled(true);
				}

			} else if (!txtObjetivoResolucion.trim().equals("")) {
				btnSave.setDisabled(false);
			} else {
				btnSave.setDisabled(true);
			}
		} else {
			if (txtObjetivoResolucion.trim().equals("")) {
				btnSave.setDisabled(true);
			} else {
				btnSave.setDisabled(false);
			}
		}
	}

	public void action_set_selected_option() {
		try {

			action_clear_objetivo_data();

			switch (txtNuevoEstadoObjetivo) {

			case "No Cumple Req.":
				if (txtEstado.equals(txtNuevoEstadoObjetivo)) {
					btnSave.setDisabled(true);
				} else {
					btnSave.setDisabled(false);
				}

				break;

			case "Cumple Req.":
				btnSave.setDisabled(true);
				break;

			case "No Aplica":
				action_set_resolucion_data();
				break;

			default:
				btnSave.setDisabled(true);
				break;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method for initialize Objetivo Detailed Form to view specific attributes 
	public String action_set_details() {
		try {
			selectedObjetivo = (ObjetivoDTO) httpSession.getAttribute("selectedObjetivo");
			selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) httpSession.getAttribute("selectedProyectoEstablecimiento");

			if(selectedObjetivo != null && selectedProyectoEstablecimiento != null) {
				estadoProyecto = businessDelegatorView.findEstadoProyectoByProyectoEstablecimientoId(
						selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

				numeralProyecto = businessDelegatorView.findProyectoByProyectoEstablecimientoId(
						selectedProyectoEstablecimiento.getIdProyectoEstablecimiento()).getNumeral();

				datoAutoevaluacion = businessDelegatorView.findDatoObjetivoAutoevaluacion(
						selectedObjetivo.getIdObjetivo());

				Norma norma = businessDelegatorView.findNormaByProyectoEstablecimientoId(
						selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
				selectedNorma = businessDelegatorView.normaToNormaDTO(norma);

				requisito = businessDelegatorView.findRequisitoByObjetivoId(selectedObjetivo.getIdObjetivo());

				establecimientoObjetivo = businessDelegatorView.findEstablecimientoObjetivoByIds(
						selectedProyectoEstablecimiento.getIdProyectoEstablecimiento(), selectedObjetivo.getIdObjetivo());

				estadoObjetivo = (establecimientoObjetivo != null) ? businessDelegatorView.
						findEstadoObjetivoByEstablecimientoObjetivoId(establecimientoObjetivo.getEstablecimientoObjetivoId())
						: null;

						txtEstado = (estadoObjetivo != null) ? estadoObjetivo.getDescripcion() : "No Iniciado";

						if (establecimientoObjetivo != null) {
							txtObjetivoResolucion = (establecimientoObjetivo.getResolucion() != null) ?
									establecimientoObjetivo.getResolucion() : "";
						}

						txtNuevoEstadoObjetivo = txtEstado;	

						loadedFiles = (establecimientoObjetivo != null) ? 
								businessDelegatorView.getDirectoryFiles(establecimientoObjetivo) : new File[0];

								btnSave = new CommandButton();
								btnSave.setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//Method that sets data up to redirect for Norma details page
	public String action_show_norma_details() {
		try {
			httpSession.setAttribute("selectedNorma", selectedNorma);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesNorma.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//Method saves Autoevaluacion Objetivo data
	public String action_save_establecimiento_bjetivo() {
		try {

			if (establecimientoObjetivo == null) {
				create_establecimiento_bjetivo();
			}

			if (loadedFiles.length == 0 && txtNuevoEstadoObjetivo.equals("Cumple Req.")) {
				FacesUtils.addErrorMessage("Debe cargar archivos para guardar datos.");
				return "";
			}

			if (txtNuevoEstadoObjetivo.equals("No Aplica") && txtObjetivoResolucion.equals("")) {
				FacesUtils.addErrorMessage("Debe describir las razones por las cuales no aplica el requisito en el establecimiento.");
			}

			update_establecimiento_objetivo();

			FacesUtils.addInfoMessage("Objetivo guardado exitosamente con estado " + txtEstado);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//Method creates EstablecimientoObjetivo
	public void create_establecimiento_bjetivo() {
		try {
			establecimientoObjetivo = new EstablecimientoObjetivo();

			establecimientoObjetivo.setObjetivo(
					businessDelegatorView.getObjetivo(selectedObjetivo.getIdObjetivo()));

			establecimientoObjetivo.setProyectoEstablecimiento(
					businessDelegatorView.getProyectoEstablecimiento(
							selectedProyectoEstablecimiento.getIdEstablecimiento_Establecimiento()));

			establecimientoObjetivo.setEstadoObjetivo(
					businessDelegatorView.findEstadoObjetivoByDescripcion(txtEstado));

			establecimientoObjetivo.setDateIn(new Date());

			businessDelegatorView.saveEstablecimientoObjetivo(establecimientoObjetivo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method updates EstablecimientoObjetivo
	public void update_establecimiento_objetivo() {
		try {
			establecimientoObjetivo.setEstadoObjetivo(
					businessDelegatorView.findEstadoObjetivoByDescripcion(txtNuevoEstadoObjetivo));

			establecimientoObjetivo.setResolucion((txtNuevoEstadoObjetivo.equals("No Aplica")) ?
					txtObjetivoResolucion : null);

			establecimientoObjetivo.setDateUpdate(new Date());

			businessDelegatorView.updateEstablecimientoObjetivo(establecimientoObjetivo);

			valorAutoevaluacion = businessDelegatorView.findValorDatosByIds(
					establecimientoObjetivo.getEstablecimientoObjetivoId(), datoAutoevaluacion.getIdDatoObjetivo());

			if (valorAutoevaluacion.size() == 0) {
				ValorDato nuevoValorDato = new ValorDato();

				nuevoValorDato.setDateIn(new Date());
				nuevoValorDato.setDatoObjetivo(datoAutoevaluacion);
				nuevoValorDato.setEstablecimientoObjetivo(establecimientoObjetivo);
				nuevoValorDato.setValor(txtNuevoEstadoObjetivo);

				businessDelegatorView.saveValorDato(nuevoValorDato);

				valorAutoevaluacion.add(nuevoValorDato);
			} else {
				valorAutoevaluacion.get(0).setDateUpdate(new Date());
				valorAutoevaluacion.get(0).setValor(txtNuevoEstadoObjetivo);

				businessDelegatorView.updateValorDato(valorAutoevaluacion.get(0));
			}

			btnSave.setDisabled(true);

			txtEstado = txtNuevoEstadoObjetivo;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String action_set_upload() {
		if (establecimientoObjetivo == null) {
			create_establecimiento_bjetivo();
		}
		return "";
	}

	//Method uploads file for Objetivo accomplishment
	public String upload(FileUploadEvent event) {
		try {
			businessDelegatorView.upload(event, establecimientoObjetivo);
			loadedFiles = businessDelegatorView.getDirectoryFiles(establecimientoObjetivo);

			Dialog dialogUpload = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
					"dialogUpload");
			dialogUpload.setVisible(false);

			btnSave.setDisabled(false);

		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ha ocurrido un error al cargar el archivo. Por favor, intente más tarde.", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "";
	}

	//Method deletes loaded file
	public String action_delete_file(ActionEvent event) {
		File file = (File) event.getComponent().getAttributes().get("file");
		try {
			boolean deleteSuccess = businessDelegatorView.deleteObjetivoFile(file);

			if (!deleteSuccess) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ha ocurrido un error al eliminar el archivo. Por favor, intente más tarde.", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

			loadedFiles = businessDelegatorView.getDirectoryFiles(establecimientoObjetivo);

			if (loadedFiles == null || loadedFiles.length == 0) {
				btnSave.setDisabled(true);
				if(txtEstado.equals("Cumple Req.")) {
					txtNuevoEstadoObjetivo = "No Iniciado";
					update_establecimiento_objetivo();
				}
				txtNuevoEstadoObjetivo = "Cumple Req.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ha ocurrido un error al eliminar el archivo. Por favor, intente más tarde.", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "";
	}

	//Method set download StreamedContent with selectedFile
	public String action_set_dwonload(ActionEvent event) {
		File file = (File) event.getComponent().getAttributes().get("file");

		try {
			download = businessDelegatorView.download(file);
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ha ocurrido un error al descargar el archivo. Por favor, intente más tarde.", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return "";
	}

	public ObjetivoDTO getSelectedObjetivo() {
		return selectedObjetivo;
	}

	public void setSelectedObjetivo(ObjetivoDTO selectedObjetivo) {
		this.selectedObjetivo = selectedObjetivo;
	}

	public Requisito getRequisito() {
		return requisito;
	}

	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}

	public String getNumeralProyecto() {
		return numeralProyecto;
	}

	public void setNumeralProyecto(String numeralProyecto) {
		this.numeralProyecto = numeralProyecto;
	}

	public ProyectoEstablecimientoDTO getSelectedProyectoEstablecimiento() {
		return selectedProyectoEstablecimiento;
	}

	public void setSelectedProyectoEstablecimiento(ProyectoEstablecimientoDTO selectedProyectoEstablecimiento) {
		this.selectedProyectoEstablecimiento = selectedProyectoEstablecimiento;
	}

	public EstadoProyecto getEstadoProyecto() {
		return estadoProyecto;
	}

	public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}

	public NormaDTO getSelectedNorma() {
		return selectedNorma;
	}

	public void setSelectedNorma(NormaDTO selectedNorma) {
		this.selectedNorma = selectedNorma;
	}

	public DatoObjetivoDTO getSelectedDatoObjetivo() {
		return selectedDatoObjetivo;
	}

	public void setSelectedDatoObjetivo(DatoObjetivoDTO selectedDatoObjetivo) {
		this.selectedDatoObjetivo = selectedDatoObjetivo;
	}

	public EstadoObjetivo getEstadoObjetivo() {
		return estadoObjetivo;
	}

	public void setEstadoObjetivo(EstadoObjetivo estadoObjetivo) {
		this.estadoObjetivo = estadoObjetivo;
	}

	public EstablecimientoObjetivo getEstablecimientoObjetivo() {
		return establecimientoObjetivo;
	}

	public void setEstablecimientoObjetivo(EstablecimientoObjetivo establecimientoObjetivo) {
		this.establecimientoObjetivo = establecimientoObjetivo;
	}

	public DatoObjetivo getDatoAutoevaluacion() {
		return datoAutoevaluacion;
	}

	public void setDatoAutoevaluacion(DatoObjetivo datoAutoevaluacion) {
		this.datoAutoevaluacion = datoAutoevaluacion;
	}

	public List<ValorDato> getValorAutoevaluacion() {
		return valorAutoevaluacion;
	}

	public void setValorAutoevaluacion(List<ValorDato> valorAutoevaluacion) {
		this.valorAutoevaluacion = valorAutoevaluacion;
	}

	public File[] getLoadedFiles() {
		return loadedFiles;
	}

	public void setLoadedFiles(File[] loadedFiles) {
		this.loadedFiles = loadedFiles;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public String getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(String txtEstado) {
		this.txtEstado = txtEstado;
	}

	public String getTxtNuevoEstadoObjetivo() {
		return txtNuevoEstadoObjetivo;
	}

	public void setTxtNuevoEstadoObjetivo(String txtNuevoEstadoObjetivo) {
		this.txtNuevoEstadoObjetivo = txtNuevoEstadoObjetivo;
	}

	public String getTxtObjetivoResolucion() {
		return txtObjetivoResolucion;
	}

	public void setTxtObjetivoResolucion(String txtObjetivoResolucion) {
		this.txtObjetivoResolucion = txtObjetivoResolucion;
	}

	public StreamedContent getDownload() {
		return download;
	}

	public void setDownload(StreamedContent download) {
		this.download = download;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}
}
