package service_flow.assignment.manager;

import org.springframework.stereotype.Component;

import service_flow.assignment.api.model.FizzBuzzResponse;
import service_flow.assignment.api.model.UserAction;

/**
 * @author Ali Raza
 */
@Component
public class FizzBuzzManager {
	
	private final static String FIZZ_RESP = "Fizz";
	private final static String BUZZ_RESP = "Buzz";
	private final static String FIZZ_BUZZ_RESP = "Fizz Buzz";
	private final static int FIZZ = 3;
	private final static int BUZZ = 5;
	
    
    public FizzBuzzResponse doPerform(final UserAction action) {
        final Integer actionVal = action.getAction();
    	if (actionVal == null) {
        	throw new RuntimeException("action field is required");
        }
    	
        final FizzBuzzResponse response = new FizzBuzzResponse();
        if (actionVal % FIZZ == 0 && actionVal % BUZZ == 0) {
        	response.setValue(FIZZ_BUZZ_RESP);
        } else if (actionVal % FIZZ == 0) {
        	response.setValue(BUZZ_RESP);
        } else if (actionVal % BUZZ == 0) {
        	response.setValue(FIZZ_RESP);
        } else {
        	response.setValue(actionVal.toString());
        }
        return response;
    }
}
