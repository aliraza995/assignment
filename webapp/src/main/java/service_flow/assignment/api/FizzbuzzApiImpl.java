package service_flow.assignment.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service_flow.assignment.api.model.ApiError;
import service_flow.assignment.api.model.FizzBuzzResponse;
import service_flow.assignment.api.model.UserAction;
import service_flow.assignment.manager.FizzBuzzManager;

/**
 * @author Ali Raza
 *
 */
@Component
public class FizzbuzzApiImpl implements FizzbuzzApi {

	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private FizzBuzzManager manager;

	@Override
	public Response doPerform(final UserAction userAction) {
		LOG.info("doPerform called with user action '{}'", userAction.getAction());
		try {

			final FizzBuzzResponse response = manager.doPerform(userAction);
			return Response.ok(response).build();

		} catch (final RuntimeException e) {
			LOG.error(e.getMessage(), e);
			final ApiError apiError = new ApiError();
			apiError.setEndUserMessage(e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(apiError).build();
		} catch (final Exception e) {
			LOG.error(e.getMessage(), e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
