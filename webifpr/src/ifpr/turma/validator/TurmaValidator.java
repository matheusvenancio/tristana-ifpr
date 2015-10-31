package ifpr.turma.validator;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "turmaValidator")
public class TurmaValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		UIInput emailInput = (UIInput) component.getAttributes().get("emailVlt");
		UIInput criacaoInput = (UIInput) component.getAttributes().get("criacaoVlt");
		
		Object emailValue = emailInput.getSubmittedValue();
		Object criacaoValue = criacaoInput.getSubmittedValue();

		if (!isEmailValid(emailValue.toString())) {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Email inválido, escolha outro");
			FacesContext.getCurrentInstance().addMessage("Atenção", message);
			FacesContext.getCurrentInstance().validationFailed();
			
			emailInput.setValid(false);
		}
		
	
		try{
			
			if(!validarAnoCriacao(new Integer(criacaoValue.toString()))){
				
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Ano Inicial inválido, escolha outro");
				FacesContext.getCurrentInstance().addMessage("Atenção", message);
				FacesContext.getCurrentInstance().validationFailed();
				
				criacaoInput.setValid(false);		
			}
			
		}catch(NumberFormatException e){
			
		}		
	}
	
    private boolean isEmailValid(String email) {
        if ((email == null) || (email.trim().length() == 0))
            return false;

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
	private boolean validarAnoCriacao(Integer criacaoValue){
		
		if(criacaoValue > Calendar.getInstance().get(Calendar.YEAR) || criacaoValue < 2009){
			return false;
		}
		
		return true;
	}
}
