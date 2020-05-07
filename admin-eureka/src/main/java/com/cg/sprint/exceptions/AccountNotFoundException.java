package com.cg.sprint.exceptions;

import com.cg.sprint.exceptions.Exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception
{
	public AccountNotFoundException()
	{
		super();
	}

	public AccountNotFoundException(String message) 
	{
		super(message);
	}
}
