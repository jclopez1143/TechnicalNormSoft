package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.*;

import org.primefaces.component.dialog.Dialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
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
public class ObjetivoEjecucionDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ObjetivoEjecucionDetailsView.class);
	private Requisito requisito;
	private String numeralProyecto;
	private ObjetivoDTO selectedObjetivo;
	private DatoObjetivoDTO selectedDatoObjetivo;
	private RegistroDatoDTO selectedRegistro;
	private ProyectoEstablecimientoDTO selectedProyectoEstablecimiento;
	private EstadoObjetivo estadoObjetivo;
	private EstablecimientoObjetivo establecimientoObjetivo;
	private HashMap<String, String> registroMap;
	private List<DatoObjetivoDTO> datosObjetivo;
	private List<RegistroDatoDTO> registros;
	private List<CampoRegistroDTO> campos;
	private HashMap<String, ValorCampoDTO> valorCampos;
	private HashMap<String, ValorDatoDTO> valorDatos;
	private boolean showDialog;
	private String txtEstado;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private HttpSession httpSession;

	public ObjetivoEjecucionDetailsView() {
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

	//clears all data from last selected DatoObjetivo
	public String action_clear_campos_registro() {
		selectedDatoObjetivo = null;
		selectedRegistro = null;
		registroMap = null;
		campos = null;

		return "";
	}


	//Closes every dialog
	public String action_closeDialog() {
		Dialog dialog = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
				"dialogRegistro");
		if (dialog != null) {
			dialog.setVisible(false);
		}

		dialog = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
				"dialogResolucion");
		if (dialog != null) {
			dialog.setVisible(false);
		}
		action_clear_campos_registro();
		return "";
	}

	//Method for initialize Objetivo Detailed Form to view specific attributes 
	public String action_set_details() {
		try {
			selectedObjetivo = (ObjetivoDTO) httpSession.getAttribute("selectedObjetivo");
			selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) httpSession.getAttribute("selectedProyectoEstablecimiento");


			if(selectedObjetivo != null && selectedProyectoEstablecimiento != null) {
				requisito = businessDelegatorView.findRequisitoByObjetivoId(selectedObjetivo.getIdObjetivo());

				establecimientoObjetivo = businessDelegatorView.findEstablecimientoObjetivoByIds(
						selectedProyectoEstablecimiento.getIdProyectoEstablecimiento(), selectedObjetivo.getIdObjetivo());

				estadoObjetivo = (establecimientoObjetivo != null) ? businessDelegatorView.
						findEstadoObjetivoByEstablecimientoObjetivoId(establecimientoObjetivo.getEstablecimientoObjetivoId())
						: null;

						txtEstado = (estadoObjetivo != null) ? estadoObjetivo.getDescripcion() : "No Iniciado";

						numeralProyecto = businessDelegatorView.findProyectoByProyectoEstablecimientoId(
								selectedProyectoEstablecimiento.getIdProyectoEstablecimiento()).getNumeral();

			}

		} catch (Exception e) {
		}
		return "";
	}

	//Method that sets data for datosObjetivo List
	public String action_set_datos_data() {
		try {

			//find all Datos list from Objetivo
			datosObjetivo = businessDelegatorView.listDatoObjetivoToListDatoObjetivoDTO(
					businessDelegatorView.findDatoObjetivosByObjetivoId(selectedObjetivo.getIdObjetivo()));

			//go through all Datos and fill each data
			for (DatoObjetivoDTO dato : datosObjetivo) {
				valorDatos = new HashMap<>();

				//find all CampoRegistros from DatoObjetivo
				List<CampoRegistro> camposRegistro = businessDelegatorView.
						findCampoRegistrosByDatoObjetivoId(dato.getIdDatoObjetivo());
				campos = (camposRegistro.size() > 0) ? 
						businessDelegatorView.listCampoRegistroToListCampoRegistroDTO(camposRegistro) : null;

						//Checks if DatoObjetivo got single value or row
						if (campos != null) {
							//find all RegistroDatos from DatoObjetvo and EstablecimientoObjetivo
							List<RegistroDato> registrosDato = new ArrayList<>();
							registrosDato = businessDelegatorView.findRegistroDatosByIds(
									establecimientoObjetivo.getEstablecimientoObjetivoId(), 
									dato.getIdDatoObjetivo());

							registros = (List<RegistroDatoDTO>) ((registrosDato.size() != 0) ?
									businessDelegatorView.listRegistroDatoToListRegistroDatoDTO(registrosDato) : new ArrayList<RegistroDatoDTO>());

							//goes through all registros and fill each data
							if (registros.size() != 0) {
								for (RegistroDatoDTO registroDato : registros) {
									valorCampos = new HashMap<>();
									//find all valorCampos from each RegistroDato
									List<ValorCampo> valores = businessDelegatorView.findValorCamposByRegistroDatoId(
											registroDato.getIdRegistroDato());

									//goes through all valores and fill CampoRegistro
									if (valores != null) {
										for (ValorCampo valorCampo : valores) {

											ValorCampoDTO valorCampoDTO = businessDelegatorView.valorCampoToValorCampoDTO(valorCampo);

											//sets CampoRegistro from ValorCampo
											valorCampoDTO.setNombreCampoRegistro(businessDelegatorView.findCampoRegistroByValorCampoId(
													valorCampo.getIdValorCampo()).getNombre());

											//puts new row field
											valorCampos.put(valorCampoDTO.getNombreCampoRegistro(), valorCampoDTO);
										}
										//sets valorCampo List to registroDato
										registroDato.setValorCampos(valorCampos);
									}
								}
								//sets registros to DatoObjetivo
								dato.setRegistroDatos(registros);
							}
							//sets campoRegistros to DatoObjetivo
							dato.setCampoRegistros(campos);
						} else {
							//Check if dato gots a value
							List<ValorDato> valores = businessDelegatorView.findValorDatosByIds(
									establecimientoObjetivo.getEstablecimientoObjetivoId(),
									dato.getIdDatoObjetivo());

							if (valores.size() > 0) {
								valorDatos.put(dato.getNombre(), businessDelegatorView.valorDatoToValorDatoDTO(
										valores.get(0)));
							} else {
								valorDatos.put(dato.getNombre(), null);
							}

						}
						dato.setValorDatos(valorDatos);
			}
		} catch (Exception e) {
		}
		return "";
	}

	//Method to initialize new HashMap for new RegistroDato data
	public String set_new_registro_dato(ActionEvent event) {    	
		registroMap = new HashMap<String, String>();

		selectedDatoObjetivo = (DatoObjetivoDTO) event.getComponent().getAttributes().get("datoObjetivo");

		try {
			campos =  businessDelegatorView.listCampoRegistroToListCampoRegistroDTO(
					businessDelegatorView.
					findCampoRegistrosByDatoObjetivoId(selectedDatoObjetivo.getIdDatoObjetivo()));

			for (CampoRegistroDTO campoRegistroDTO : campos) {
				registroMap.put(campoRegistroDTO.getNombre(), "");
			}

			Dialog dialogDato = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
					"dialogRegistro");
			dialogDato.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//Method to initialize new HashMap for RegistroDato data to update
	public String set_update_registro_dato(ActionEvent event) {  
		try {
			registroMap = new HashMap<String, String>();

			selectedRegistro = (RegistroDatoDTO) event.getComponent().
					getAttributes().get("registroDato");

			selectedDatoObjetivo = (DatoObjetivoDTO) event.getComponent().getAttributes().get("datoObjetivo");

			CampoRegistro campoRegistro = new CampoRegistro();

			List<ValorCampo> valores = businessDelegatorView.findValorCamposByRegistroDatoId(
					selectedRegistro.getIdRegistroDato());

			for(ValorCampo valorCampo : valores) {
				campoRegistro = businessDelegatorView.findCampoRegistroByValorCampoId(
						valorCampo.getIdValorCampo());

				registroMap.put(campoRegistro.getNombre(), valorCampo.getValor());
			}

			Dialog dialogDato = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
					"dialogRegistro");
			dialogDato.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//Method that sets data up to redirect for Requisito details page
	public String action_show_requisito_details() {
		try {
			RequisitoDTO selectedRequisito = businessDelegatorView.requisitoToRequisitoDTO(requisito);
			httpSession.setAttribute("selectedRequisito", selectedRequisito);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesRequisito.xhtml");
		} catch (Exception e) {
		}
		return "";
	}

	public String action_save_registro() {
		if (selectedRegistro == null) {
			action_create_registro();
		} else {
			action_modify_registro();
		}
		return "";
	}

	//Method that creates new RegistroDato
	public String action_create_registro() {
		try {
			RegistroDato nuevoRegistro = new RegistroDato();

			nuevoRegistro.setEstablecimientoObjetivo(establecimientoObjetivo);
			nuevoRegistro.setDatoObjetivo(businessDelegatorView.getDatoObjetivo(
					selectedDatoObjetivo.getIdDatoObjetivo()));
			nuevoRegistro.setDateIn(new Date());

			businessDelegatorView.saveRegistroDato(nuevoRegistro);

			for(CampoRegistroDTO campoRegistroDTO : campos) {
				ValorCampo nuevoValorCampo = new ValorCampo();
				nuevoValorCampo.setCampoRegistro(businessDelegatorView.getCampoRegistro(
						campoRegistroDTO.getIdCampoRegistro()));
				nuevoValorCampo.setRegistroDato(nuevoRegistro);

				switch (campoRegistroDTO.getTipo()) {
				case "date":
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					nuevoValorCampo.setValor(sdf.format(registroMap.get(campoRegistroDTO.getNombre())));
					break;

				case "boolean":
					nuevoValorCampo.setValor(String.valueOf(registroMap.get(campoRegistroDTO.getNombre())));
					break;

				default:
					nuevoValorCampo.setValor(registroMap.get(campoRegistroDTO.getNombre())+"");
					break;
				}

				nuevoValorCampo.setDateIn(new Date());

				businessDelegatorView.saveValorCampo(nuevoValorCampo);
			}

			FacesUtils.addInfoMessage("Registro creado exitosamente.");
			action_set_datos_data();
			action_closeDialog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	//Method that updates RegistroDato
	public String action_modify_registro() {
		try {

			CampoRegistro campoRegistro = new CampoRegistro();

			List<ValorCampo> valores = businessDelegatorView.findValorCamposByRegistroDatoId(
					selectedRegistro.getIdRegistroDato());

			for(ValorCampo valorCampo : valores) {
				campoRegistro = businessDelegatorView.findCampoRegistroByValorCampoId(
						valorCampo.getIdValorCampo());

				switch (campoRegistro.getTipo()) {
				case "date":
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					valorCampo.setValor(sdf.format(registroMap.get(campoRegistro.getNombre())));
					break;

				case "boolean":
					valorCampo.setValor(String.valueOf(registroMap.get(campoRegistro.getNombre())));
					break;

				default:
					valorCampo.setValor(registroMap.get(campoRegistro.getNombre())+"");
					break;
				}

				valorCampo.setDateUpdate(new Date());

				businessDelegatorView.updateValorCampo(valorCampo);
			}

			RegistroDato registroDato = businessDelegatorView.getRegistroDato(
					selectedRegistro.getIdRegistroDato());

			registroDato.setDateUpdate(new Date());

			businessDelegatorView.updateRegistroDato(registroDato);

			FacesUtils.addInfoMessage("Registro actualizado exitosamente.");
			action_set_datos_data();
			action_closeDialog();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	//Method that delete from data table
	public String action_delete_datatable(ActionEvent evt) {
		try {            
			selectedRegistro = (RegistroDatoDTO) evt.getComponent().getAttributes()
					.get("registroDato");

			businessDelegatorView.deleteRegistroDatoFull(businessDelegatorView.getRegistroDato(
					selectedRegistro.getIdRegistroDato()));
			action_set_datos_data();
			action_clear_campos_registro();

			FacesUtils.addInfoMessage("Registro eliminado exitosamente.");
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	//shows resolve dialog for Objetivo
	public String action_resolve_objetivo() {
		Dialog dialog = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
				"dialogResolucion");
		dialog.setVisible(true);
		return "";
	}

	//finish Objetivo
	public String action_finish_objetivo() {
		if (datosObjetivo != null) {

			Dialog dialog = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
					"dialogResolucion");
			dialog.setVisible(false);
		} else {
			FacesUtils.addErrorMessage("Debe registrar datos en el objetivo para finalizarlo");
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

	public DatoObjetivoDTO getSelectedDatoObjetivo() {
		return selectedDatoObjetivo;
	}

	public void setSelectedDatoObjetivo(DatoObjetivoDTO selectedDatoObjetivo) {
		this.selectedDatoObjetivo = selectedDatoObjetivo;
	}

	public RegistroDatoDTO getSelectedRegistro() {
		return selectedRegistro;
	}

	public void setSelectedRegistro(RegistroDatoDTO selectedRegistro) {
		this.selectedRegistro = selectedRegistro;
	}

	public HashMap<String, ValorDatoDTO> getValorDatos() {
		return valorDatos;
	}

	public void setValorDatos(HashMap<String, ValorDatoDTO> valorDatos) {
		this.valorDatos = valorDatos;
	}

	public EstadoObjetivo getEstadoObjetivo() {
		return estadoObjetivo;
	}

	public void setEstadoObjetivo(EstadoObjetivo estadoObjetivo) {
		this.estadoObjetivo = estadoObjetivo;
	}

	public HashMap<String, String> getRegistroMap() {
		return registroMap;
	}

	public void setRegistroMap(HashMap<String, String> registroMap) {
		this.registroMap = registroMap;
	}

	public List<DatoObjetivoDTO> getDatosObjetivo() {
		if (datosObjetivo == null) {
			action_set_datos_data();
		}
		return datosObjetivo;
	}

	public void setDatosObjetivo(List<DatoObjetivoDTO> datosObjetivo) {
		this.datosObjetivo = datosObjetivo;
	}

	public List<RegistroDatoDTO> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroDatoDTO> registros) {
		this.registros = registros;
	}

	public List<CampoRegistroDTO> getCampos() {
		return campos;
	}

	public void setCampos(List<CampoRegistroDTO> campos) {
		this.campos = campos;
	}

	public HashMap<String, ValorCampoDTO> getValorCampos() {
		return valorCampos;
	}

	public void setValorCampos(HashMap<String, ValorCampoDTO> valorCampos) {
		this.valorCampos = valorCampos;
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
}
