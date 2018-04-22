/**
 * 
 */
package com.fiberlink.idaas.service;

import com.fiberlink.security.EncryptDecryptUtils;

/**
 * @author gsakthivel
 *
 */
public class EncrptDecryptSecret {

	private final static String DEFAULT_ENCRYPTION_KEY = "f8er7e8nxcxjkfh3";
	
	private final static String SBS_CLEINT_ID_M1="9cc148f6-fde9-4b3b-9e18-2cd9d2f88f01";
	private final static String SBS_CLEINT_ID_M2="af826da3-4f39-4d13-9628-db544980700d";
	private final static String SBS_CLEINT_ID_M3="7d907a14-4ec3-424e-9148-4e51867e5ad1";
	private final static String SBS_CLEINT_ID_M4="5bdb160b-e8c6-4655-aaa5-957f526a31c1";
	private final static String SBS_CLEINT_ID_STAGE="5fe0ca0c-a52a-4316-a43f-8bdca989f463";
	
	private final static String SBS_CLEINT_ID_Q1="9b1f93cf-55f6-4ff3-ac70-41314ae0f54d";
	private final static String SBS_CLEINT_ID_Q2="9b1f93cf-55f6-4ff3-ac70-41314ae0f54d";
	private final static String SBS_CLEINT_ID_Q3="9b1f93cf-55f6-4ff3-ac70-41314ae0f54d";
	private final static String SBS_CLEINT_ID_D2="9b1f93cf-55f6-4ff3-ac70-41314ae0f54d";
	private final static String SBS_CLEINT_ID_D3="9b1f93cf-55f6-4ff3-ac70-41314ae0f54d";
	private final static String SBS_CLEINT_ID_D4="9b1f93cf-55f6-4ff3-ac70-41314ae0f54d";
	
	
	private final static String SBS_CLEINT_SECRET_M1="X5dE1wR7dC8gX4hC7eU4hJ7sM0uF8jN4sY3aS8tC5rA2uS2eX3";
	private final static String SBS_CLEINT_SECRET_M2="Y2jR1oL8aA4uO8lB3dY0hH1nE0sQ2kW6dW3lP7mQ1bL8qU3jQ0";
	private final static String SBS_CLEINT_SECRET_M3="yT5dI7bE8hQ1sD6fI6gH8oE4kB5cO1eU1nI1dX2oJ7rG5iS8jB";
	private final static String SBS_CLEINT_SECRET_M4="N7jY1cA4pJ0iL3fB0eD8cF0mB3mO0mU5hU1uE8jR7hT6kE6jB0";
	private final static String SBS_CLEINT_SECRET_STAGE="V5yJ8sB8mB7eN7nQ4iW3nG7xT4bL4xA5aJ3fS0aO7rJ7jA6uL1";
	
	private final static String SBS_CLEINT_SECRET_Q1="cH6jN8dN3jI6jF4aO8cJ0cF3vA7yE6sX7rP5hN2sS8qJ2eL2fM";
	private final static String SBS_CLEINT_SECRET_Q2="cH6jN8dN3jI6jF4aO8cJ0cF3vA7yE6sX7rP5hN2sS8qJ2eL2fM";
	private final static String SBS_CLEINT_SECRET_Q3="cH6jN8dN3jI6jF4aO8cJ0cF3vA7yE6sX7rP5hN2sS8qJ2eL2fM";
	private final static String SBS_CLEINT_SECRET_D2="cH6jN8dN3jI6jF4aO8cJ0cF3vA7yE6sX7rP5hN2sS8qJ2eL2fM";
	private final static String SBS_CLEINT_SECRET_D3="cH6jN8dN3jI6jF4aO8cJ0cF3vA7yE6sX7rP5hN2sS8qJ2eL2fM";
	private final static String SBS_CLEINT_SECRET_D4="cH6jN8dN3jI6jF4aO8cJ0cF3vA7yE6sX7rP5hN2sS8qJ2eL2fM";
	
	private final static String IDAAS_CLEINT_ID_M1="MTM4YzI3NjEtYmI1YS00";
	private final static String IDAAS_CLEINT_ID_M2="MTM4YzI3NjEtYmI1YS00";
	private final static String IDAAS_CLEINT_ID_M3="MTM4YzI3NjEtYmI1YS00";
	private final static String IDAAS_CLEINT_ID_M4="MTM4YzI3NjEtYmI1YS00";
	private final static String IDAAS_CLEINT_ID_STAGE="KEPAIFNGCFEH";
	
	private final static String IDAAS_CLEINT_ID_Q1="MWRkNjRhMzktOTEyOS00";
	private final static String IDAAS_CLEINT_ID_Q2="VQSSSTYVTGDA";
	private final static String IDAAS_CLEINT_ID_Q3="MASAFYAIDZMZ";
	private final static String IDAAS_CLEINT_ID_D2="KLLYQHVFKHSO";
	private final static String IDAAS_CLEINT_ID_D3="FTQFBHVCKQUD";
	private final static String IDAAS_CLEINT_ID_D4="PTHVYEEGOFND";
	
	private final static String IDAAS_CLEINT_SECRET_M1="ZGZhN2RjNjAtNzhiNi00";
	private final static String IDAAS_CLEINT_SECRET_M2="ZGZhN2RjNjAtNzhiNi00";
	private final static String IDAAS_CLEINT_SECRET_M3="ZGZhN2RjNjAtNzhiNi00";
	private final static String IDAAS_CLEINT_SECRET_M4="ZGZhN2RjNjAtNzhiNi00";
	private final static String IDAAS_CLEINT_SECRET_STAGE="EFNVEXODMJSI";
	
	private final static String IDAAS_CLEINT_SECRET_Q1="M2ZmMDBkNmMtMmIxYi00";
	private final static String IDAAS_CLEINT_SECRET_Q2="AXJAAPRETLZT";
	private final static String IDAAS_CLEINT_SECRET_Q3="KWPKBFNBZMAI";
	private final static String IDAAS_CLEINT_SECRET_D2="EULIGSWKXNAT";
	private final static String IDAAS_CLEINT_SECRET_D3="HGBDGUKINCUO";
	private final static String IDAAS_CLEINT_SECRET_D4="KWBPWBJQCFSA";
	
	public static void main(String[] args) {
		try {
			System.out.println("SBS Client Id M1:"+SBS_CLEINT_ID_M1+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_M1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id M2:"+SBS_CLEINT_ID_M2+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_M2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id M3:"+SBS_CLEINT_ID_M3+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_M3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id M4:"+SBS_CLEINT_ID_M4+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_M4, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id Stage:"+SBS_CLEINT_ID_STAGE+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_STAGE, DEFAULT_ENCRYPTION_KEY));
			
			System.out.println("SBS Client Id Q1:"+SBS_CLEINT_ID_Q1+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_Q1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id Q2:"+SBS_CLEINT_ID_Q2+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_Q2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id Q3:"+SBS_CLEINT_ID_Q3+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_Q3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id D2:"+SBS_CLEINT_ID_D2+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_D2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id D3:"+SBS_CLEINT_ID_D3+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_D3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Id D4:"+SBS_CLEINT_ID_D4+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_ID_D4, DEFAULT_ENCRYPTION_KEY));
			
			
			System.out.println("SBS Client Secret M1:"+SBS_CLEINT_SECRET_M1+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_M1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret M2:"+SBS_CLEINT_SECRET_M2+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_M2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret M3:"+SBS_CLEINT_SECRET_M3+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_M3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret M4:"+SBS_CLEINT_SECRET_M4+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_M4, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret Stage:"+SBS_CLEINT_SECRET_STAGE+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_STAGE, DEFAULT_ENCRYPTION_KEY));
			
			System.out.println("SBS Client Secret Q1:"+SBS_CLEINT_SECRET_Q1+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_Q1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret Q2:"+SBS_CLEINT_SECRET_Q2+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_Q2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret Q3:"+SBS_CLEINT_SECRET_Q3+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_Q3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret D2:"+SBS_CLEINT_SECRET_D2+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_D2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret D3:"+SBS_CLEINT_SECRET_D3+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_D3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("SBS Client Secret D4:"+SBS_CLEINT_SECRET_D4+" -->"+EncryptDecryptUtils.encryptWithTDES(SBS_CLEINT_SECRET_D4, DEFAULT_ENCRYPTION_KEY));
			
			System.out.println("Idaas Client Id M1:"+IDAAS_CLEINT_ID_M1+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_M1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id M2:"+IDAAS_CLEINT_ID_M2+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_M2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id M3:"+IDAAS_CLEINT_ID_M3+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_M3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id M4:"+IDAAS_CLEINT_ID_M4+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_M4, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id Stage:"+IDAAS_CLEINT_ID_STAGE+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_STAGE, DEFAULT_ENCRYPTION_KEY));
			
			System.out.println("Idaas Client Id Q1:"+IDAAS_CLEINT_ID_Q1+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_Q1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id Q2:"+IDAAS_CLEINT_ID_Q2+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_Q2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id Q3:"+IDAAS_CLEINT_ID_Q3+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_Q3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id D2:"+IDAAS_CLEINT_ID_D2+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_D2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id D3:"+IDAAS_CLEINT_ID_D3+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_D3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Id D4:"+IDAAS_CLEINT_ID_D4+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_ID_D4, DEFAULT_ENCRYPTION_KEY));
			
			System.out.println("Idaas Client Secret M1:"+IDAAS_CLEINT_SECRET_M1+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_M1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret M2:"+IDAAS_CLEINT_SECRET_M2+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_M2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret M3:"+IDAAS_CLEINT_SECRET_M3+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_M3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret M4:"+IDAAS_CLEINT_SECRET_M4+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_M4, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret Stage:"+IDAAS_CLEINT_SECRET_STAGE+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_STAGE, DEFAULT_ENCRYPTION_KEY));
			
			System.out.println("Idaas Client Secret Q1:"+IDAAS_CLEINT_SECRET_Q1+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_Q1, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret Q2:"+IDAAS_CLEINT_SECRET_Q2+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_Q2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret Q3:"+IDAAS_CLEINT_SECRET_Q3+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_Q3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret D2:"+IDAAS_CLEINT_SECRET_D2+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_D2, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret D3:"+IDAAS_CLEINT_SECRET_D3+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_D3, DEFAULT_ENCRYPTION_KEY));
			System.out.println("Idaas Client Secret D4:"+IDAAS_CLEINT_SECRET_D4+" -->"+EncryptDecryptUtils.encryptWithTDES(IDAAS_CLEINT_SECRET_D4, DEFAULT_ENCRYPTION_KEY));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
