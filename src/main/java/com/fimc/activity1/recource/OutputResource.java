package com.fimc.activity1.recource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;


@Component
@Path("/calculator")
public class OutputResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculator(InputResource inputResource) {
		
		ResultResource resultResource = new ResultResource();
		
		
		if(inputResource.getOperator().equals("") || inputResource.getNum1().equals("") || inputResource.getNum2().equals("")) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		
		} else if (!inputResource.getNum1().matches("[0-9]+") || !inputResource.getNum2().matches("[0-9]+")) {
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		} else if (!inputResource.getOperator().matches("[+-/*]+")) {
			return Response.status(Response.Status.BAD_REQUEST).build();	
		}else {
			
			int num1 = Integer.parseInt(inputResource.getNum1());
			int num2 = Integer.parseInt(inputResource.getNum2());
			
			
			 if (inputResource.getOperator().equals("+")) {
				resultResource.setAction("Addition");
				resultResource.setResult(num1 + num2);
				return Response.ok(resultResource).status(Response.Status.OK).build();
			} else if (inputResource.getOperator().equals("-")) {
				resultResource.setAction("Subtraction");
				resultResource.setResult(num1 - num2);
				return Response.ok(resultResource).status(Response.Status.OK).build();
			} else if (inputResource.getOperator().equals("*")) {
				resultResource.setAction("Multiplication");
				resultResource.setResult(num1 * num2);
				return Response.ok(resultResource).status(Response.Status.OK).build();
			} else if (inputResource.getOperator().equals("/")) {
				if(num2 == 0) {
					return Response.status(Response.Status.BAD_REQUEST).build();
				}else {
				resultResource.setAction("Division");
				resultResource.setResult(Double.parseDouble(String.format("%.5f", Double.valueOf(inputResource.getNum1()) / Double.valueOf(inputResource.getNum2()))));
				return Response.ok(resultResource).status(Response.Status.OK).build();
				}
				
			} else {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
		}
		
	}
}