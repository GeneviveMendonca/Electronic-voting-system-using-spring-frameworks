package com.electronicvotingsystem.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.electronicvotingsystem.exception.AdminAlreadyExistsException;
import com.electronicvotingsystem.exception.AdminNotFoundException;
import com.electronicvotingsystem.exception.CandidateAlreadyExistsException;
import com.electronicvotingsystem.exception.CandidateNotFoundException;
import com.electronicvotingsystem.exception.ElectionAlreadyExistsException;
import com.electronicvotingsystem.exception.ElectionNotFoundException;
import com.electronicvotingsystem.exception.ElectoralOfficerAlreadyExistsException;
import com.electronicvotingsystem.exception.ElectoralOfficerNotFoundException;
import com.electronicvotingsystem.exception.PartyAlreadyExistsException;
import com.electronicvotingsystem.exception.PartyNotFoundException;
import com.electronicvotingsystem.exception.ScheduleAlreadyExistsException;
import com.electronicvotingsystem.exception.ScheduleNotFoundException;
import com.electronicvotingsystem.exception.UserAlreadyExistsException;
import com.electronicvotingsystem.exception.UserNotFoundException;
import com.electronicvotingsystem.exception.VoterAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterNotFoundException;
import com.electronicvotingsystem.exception.VoterRequestAlreadyExistsException;
import com.electronicvotingsystem.exception.VoterRequestNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//UserAlreadyExistsException
	
	@ExceptionHandler(value = { UserAlreadyExistsException.class })

	protected ResponseEntity<Object> handleConflict( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This UserAlready Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	//UserNotFoundException
	
	@ExceptionHandler(value = { UserNotFoundException.class })

	protected ResponseEntity<Object> handleConflict2( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "User Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	//VoterNotFoundException
	
	@ExceptionHandler(value = { VoterNotFoundException.class })

	protected ResponseEntity<Object> handleException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Voter Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	//voterAlreadyExistsException
	
	@ExceptionHandler(value = { VoterAlreadyExistsException.class })

	protected ResponseEntity<Object> handleException1( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This Voter Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}

	//CandidateNotFoundException
	
	@ExceptionHandler(value = { CandidateNotFoundException.class })

	protected ResponseEntity<Object> handleExceptions( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Candidate Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	//CandidateAlreadyExistsException
	
	@ExceptionHandler(value = { CandidateAlreadyExistsException.class })

	protected ResponseEntity<Object> handleExceptionss( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This Candidate Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}

	//PartyNotFoundException
	
	@ExceptionHandler(value = {PartyNotFoundException.class })

	protected ResponseEntity<Object> handleExceptionss2( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Party Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	//PartyAlreadyExistsException
	
	@ExceptionHandler(value = { PartyAlreadyExistsException.class })

	protected ResponseEntity<Object> handleExceptionss1( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This party Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	//VoterRequestNotFoundException
	
	@ExceptionHandler(value = {VoterRequestNotFoundException.class })

	protected ResponseEntity<Object>VoterRequestNotFoundException ( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "VoterRequest Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	//VoterAlreadyExistsException
	
	@ExceptionHandler(value = { VoterRequestAlreadyExistsException.class })

	protected ResponseEntity<Object> VoterRequestAlreadyExistsException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This party Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	//Election not found Exception
	
	@ExceptionHandler(value = {ElectionNotFoundException.class })

	protected ResponseEntity<Object> ElectionNotFoundException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Election Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	//ElectionAlreadyExistsException

	@ExceptionHandler(value = { ElectionAlreadyExistsException.class })

	protected ResponseEntity<Object> ElectionAlreadyExistsException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This Election Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}

	// ScheduleAlreadyExistsException

	@ExceptionHandler(value = { ScheduleAlreadyExistsException.class })

	protected ResponseEntity<Object> ScheduleAlreadyExistsException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This Schedule Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	//ScheduleNotFoundException
	
	@ExceptionHandler(value = {ScheduleNotFoundException.class })

	protected ResponseEntity<Object> ScheduleNotFoundException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Schedule Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	//AdminAlreadyExistsException
	
	@ExceptionHandler(value = { AdminAlreadyExistsException.class })

	protected ResponseEntity<Object> AdminAlreadyExistsException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This Admin Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	//AdminNotFoundException
	
	@ExceptionHandler(value = {AdminNotFoundException.class })

	protected ResponseEntity<Object> AdminNotFoundException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "Admin Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	//ElectoralOfficerAlreadyExistsException
	
	@ExceptionHandler(value = { ElectoralOfficerAlreadyExistsException.class })

	protected ResponseEntity<Object> ElectoralOfficerAlreadyExistsException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "This ElectoralOfficer Already Exist";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
	}
	
	//ElectoralOfficerNotFoundException
	
	@ExceptionHandler(value = {ElectoralOfficerNotFoundException.class })

	protected ResponseEntity<Object> ElectoralOfficerNotFoundException( RuntimeException ex, WebRequest request) {

		String bodyOfResponse = "ElectoralOfficer Not Found ";

		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}