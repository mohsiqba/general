package com.test.azuread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.ServiceUnavailableException;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;

public class TestAzureADAuthentication {
	private final static String AUTHORITY = "https://login.microsoftonline.com/common/";

	public static void main(String[] args) throws Exception {
		String username = "testauth2@ceqatestdirectory.onmicrosoft.com";
		String password = "slave@123";
		AuthenticationResult ar = getAccessTokenFromUserCredentials(username, password);
		System.out.println("Access token : "+ar.getAccessToken());
		System.out.println("Access Token type : "+ar.getAccessTokenType());
		System.out.println("Expires After :"+ar.getExpiresAfter());
		System.out.println("Expires on :"+ar.getExpiresOn());
		System.out.println("Id Token :"+ar.getIdToken());
		System.out.println("Refresh Token :"+ar.getRefreshToken());
		System.out.println("Class :"+ar.getClass());
		System.out.println("Expires Date :"+ar.getExpiresOnDate());
		System.out.println("User Info :"+ar.getUserInfo().toString());
		System.out.println("Unique Id : "+ar.getUserInfo().getUniqueId());
		System.out.println("Displayble Id : "+ar.getUserInfo().getDisplayableId());
	}

	/**
	 * Access token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkZTaW11RnJGTm9DMHNKWEdtdjEzbk5aY2VEYyIsImtpZCI6IkZTaW11RnJGTm9DMHNKWEdtdjEzbk5aY2VEYyJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLndpbmRvd3MubmV0IiwiaXNzIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvOGFjMWJhMGQtNWRjMy00MDZjLWE0YTctZmU3NGUwY2IwYzJlLyIsImlhdCI6MTUyMTc4MzI1NCwibmJmIjoxNTIxNzgzMjU0LCJleHAiOjE1MjE3ODcxNTQsImFjciI6IjEiLCJhaW8iOiJBU1FBMi84R0FBQUEzWFoxSXhVdnI1c1ROSlQ4UDh2eGJXcVNQZm5WSTFQOXpsTFcyeHRZRWFjPSIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiJjZmYwMjA0Ni1lNzc2LTRjMTQtYmEzYy00MDhiYWRmZjEzOTEiLCJhcHBpZGFjciI6IjAiLCJlX2V4cCI6MjYyODAwLCJpcGFkZHIiOiIxMDMuNjkuMjEuMTE1IiwibmFtZSI6Ik1vaHMgaXFiYSIsIm9pZCI6ImI3OGI3NTAwLTVhZmQtNGZlOC1iODRmLTgxZGQ5NTQ2YzZhYSIsInB1aWQiOiIxMDAzM0ZGRkE5OUFDRUNBIiwic2NwIjoiVXNlci5SZWFkIiwic3ViIjoiV1Z6OFR3aHBtOGx1Z044dXF0RFgtSlkxQlFzeEI2LXF0T25PTHJOeG9iNCIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJBUyIsInRpZCI6IjhhYzFiYTBkLTVkYzMtNDA2Yy1hNGE3LWZlNzRlMGNiMGMyZSIsInVuaXF1ZV9uYW1lIjoibW9oc2lxYmFAY2VxYXRlc3RkaXJlY3Rvcnkub25taWNyb3NvZnQuY29tIiwidXBuIjoibW9oc2lxYmFAY2VxYXRlc3RkaXJlY3Rvcnkub25taWNyb3NvZnQuY29tIiwidXRpIjoiOHZlenZURXcwVXlfSzhTa0NRRUNBQSIsInZlciI6IjEuMCJ9.Oas-LZPO0j84KIAgHYdGwS8WSFqmkicN14uvcgrf4SgPOKlGskPqPZfBlxMQHANCjErKqWWrUEpRhj46uZGaDb3XoLy6gTrha9gk6Brs6vwKZ5pWOMO6aHWsN2poO1MXKz2nHwmok549OMQ7Ou8eoZL1IK0eAWejgF39laKUDgQsjTbfhxtlkECb8aEh3BhTX5C59MQTCh4VEf7L-9WYkorGZ0dXlUrgO4ZcA2nwuz7zVvEGr9ZAukwLZYVEsC7EWNaErrey4oeF5_sJgGRsf-o_Kiode61U0ntH7VBpjwVjhsHy0gxgz5hP1Ka5iYzWPpKxtoeTZpigi-YaS_OTlg
Access Token type : Bearer
Expires After :3599
Expires on :3599
Id Token :eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiJjZmYwMjA0Ni1lNzc2LTRjMTQtYmEzYy00MDhiYWRmZjEzOTEiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84YWMxYmEwZC01ZGMzLTQwNmMtYTRhNy1mZTc0ZTBjYjBjMmUvIiwiaWF0IjoxNTIxNzgzMjU0LCJuYmYiOjE1MjE3ODMyNTQsImV4cCI6MTUyMTc4NzE1NCwiYW1yIjpbInB3ZCJdLCJpcGFkZHIiOiIxMDMuNjkuMjEuMTE1IiwibmFtZSI6Ik1vaHMgaXFiYSIsIm9pZCI6ImI3OGI3NTAwLTVhZmQtNGZlOC1iODRmLTgxZGQ5NTQ2YzZhYSIsInN1YiI6IjQyQ3Y0NU1zZUxKOWZlYTIyWjV3QVhjNktzTkdaWHl1emNjc1hYM1FJSXciLCJ0aWQiOiI4YWMxYmEwZC01ZGMzLTQwNmMtYTRhNy1mZTc0ZTBjYjBjMmUiLCJ1bmlxdWVfbmFtZSI6Im1vaHNpcWJhQGNlcWF0ZXN0ZGlyZWN0b3J5Lm9ubWljcm9zb2Z0LmNvbSIsInVwbiI6Im1vaHNpcWJhQGNlcWF0ZXN0ZGlyZWN0b3J5Lm9ubWljcm9zb2Z0LmNvbSIsInZlciI6IjEuMCJ9.
Refresh Token :AQABAAAAAABHh4kmS_aKT5XrjzxRAtHzthWNJvcZn2YtHDkNYE0e1rHg2_qJuFRNcBcs2IjTureDYxrKJTDKPK9n38OBUQ8VWSgo1lFJ3_zfQi70LaiItUNRvyvhL6vOIaVQpnZ8kWWfiHwsM2M9QdwiiCKY3FdI-gp8k0WIWkR37bICy9Wd5A2zbX3Z76eALxOCmZ0dtsIbOvcv3sEtAdiHuoQ6u6-19E_GHnj--h2UKhNizUW4yrNvM8qEM_5vx54fW2Jy5Axg7eYi5bMI8mktfrTmNs8_w0WOlNh0FdL7b4lXHlFRSZgz8oBffE5Ae6zI7bilLvoXwkx3lQpk29JQFXSoBxhMmPw2HmPjmMProW4OvrgJgdu1IW4Ybl8R9HeGk2ONWUQ4ed2NFEVvpn5gXhUtbmvFnoMC51Lhq18zeN7caBG-NAsEZMvTFy18n_wTb9YlRgK9jqw4cJ-CCK_O5c9-936XByIPPLLU75NPuD0jY0Mn_ORrbPiUhtncEjwYJjORfbFSLe6wsxcrxM9jfyqSUsW2BaFbqliUkEzdpA12UJH8G-OFTMyXCU8zdytmPHaXMqPHQUK1B5TvPmEEnhbuAUT2vLgqcdUCs1VHj2DKLWkwpXpkG2CiQNQuNOZQZSNmxMzdowsgcfAEfbZLim95VRpkHRHYvSd2h5R92kg4F1uEY9m43M7xnHoEakIXATrKMLO5wQGe95fPjZ4Du9JxHVnYIAA
Class :class com.microsoft.aad.adal4j.AuthenticationResult
Expires Date :Fri Mar 23 12:09:15 IST 2018
User Info :com.microsoft.aad.adal4j.UserInfo@70177ecd
Unique Id : b78b7500-5afd-4fe8-b84f-81dd9546c6aa
Displayble Id : mohsiqba@ceqatestdirectory.onmicrosoft.com
	 */
	private static AuthenticationResult getAccessTokenFromUserCredentials(String username, String password)
			throws Exception {
		AuthenticationContext context = null;
		AuthenticationResult result = null;
		ExecutorService service = null;
		String clientId = "cff02046-e776-4c14-ba3c-408badff1391";
		try {
			service = Executors.newFixedThreadPool(1);
			context = new AuthenticationContext(AUTHORITY, false, service);

			Future<AuthenticationResult> future = context.acquireToken("https://graph.windows.net", clientId, username,
					password, null);
			result = future.get();

		} finally {
			service.shutdown();
		}

		if (result == null) {
			throw new ServiceUnavailableException("authentication result was null");
		}
		return result;
	}
}
