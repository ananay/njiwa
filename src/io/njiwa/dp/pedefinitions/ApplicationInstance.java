/*
 * Njiwa Open Source Embedded M2M UICC Remote Subscription Manager
 * 
 * 
 * Copyright (C) 2019 - , Digital Solutions Ltd. - http://www.dsmagic.com
 *
 * Njiwa Dev <dev@njiwa.io>
 * 
 * This program is free software, distributed under the terms of
 * the GNU General Public License.
 */ 

/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package io.njiwa.dp.pedefinitions;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.types.BerOctetString;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ApplicationInstance {

	public static class ProcessData {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		private List<BerOctetString> seqOf = null;

		public ProcessData() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public ProcessData(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public List<BerOctetString> getBerOctetString() {
			if (seqOf == null) {
				seqOf = new ArrayList<BerOctetString>();
			}
			return seqOf;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			int codeLength;

			if (code != null) {
				codeLength = code.length;
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
			}
			else {
				codeLength = 0;
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(os, true);
				}

				codeLength += BerLength.encodeLength(os, codeLength);

			}

			if (explicit) {
				codeLength += id.encode(os);
			}

			return codeLength;
		}

		public int decode(InputStream is, boolean explicit) throws IOException {
			int codeLength = 0;
			int subCodeLength = 0;
			BerIdentifier berIdentifier = new BerIdentifier();
			if (explicit) {
				codeLength += id.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			codeLength += length.decode(is);
			int totalLength = length.val;

			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	private ApplicationIdentifier applicationLoadPackageAID = null;

	private ApplicationIdentifier classAID = null;

	private ApplicationIdentifier instanceAID = null;

	private ApplicationIdentifier extraditeSecurityDomainAID = null;

	private BerOctetString applicationPrivileges = null;

	private BerOctetString lifeCycleState = null;

	private BerOctetString applicationSpecificParametersC9 = null;

	private ApplicationSystemParameters systemSpecificParameters = null;

	private UICCApplicationParameters applicationParameters = null;

	private ProcessData processData = null;

	public ApplicationInstance() {
		id = identifier;
	}

	public ApplicationInstance(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public void setApplicationLoadPackageAID(ApplicationIdentifier applicationLoadPackageAID) {
		this.applicationLoadPackageAID = applicationLoadPackageAID;
	}

	public ApplicationIdentifier getApplicationLoadPackageAID() {
		return applicationLoadPackageAID;
	}

	public void setClassAID(ApplicationIdentifier classAID) {
		this.classAID = classAID;
	}

	public ApplicationIdentifier getClassAID() {
		return classAID;
	}

	public void setInstanceAID(ApplicationIdentifier instanceAID) {
		this.instanceAID = instanceAID;
	}

	public ApplicationIdentifier getInstanceAID() {
		return instanceAID;
	}

	public void setExtraditeSecurityDomainAID(ApplicationIdentifier extraditeSecurityDomainAID) {
		this.extraditeSecurityDomainAID = extraditeSecurityDomainAID;
	}

	public ApplicationIdentifier getExtraditeSecurityDomainAID() {
		return extraditeSecurityDomainAID;
	}

	public void setApplicationPrivileges(BerOctetString applicationPrivileges) {
		this.applicationPrivileges = applicationPrivileges;
	}

	public BerOctetString getApplicationPrivileges() {
		return applicationPrivileges;
	}

	public void setLifeCycleState(BerOctetString lifeCycleState) {
		this.lifeCycleState = lifeCycleState;
	}

	public BerOctetString getLifeCycleState() {
		return lifeCycleState;
	}

	public void setApplicationSpecificParametersC9(BerOctetString applicationSpecificParametersC9) {
		this.applicationSpecificParametersC9 = applicationSpecificParametersC9;
	}

	public BerOctetString getApplicationSpecificParametersC9() {
		return applicationSpecificParametersC9;
	}

	public void setSystemSpecificParameters(ApplicationSystemParameters systemSpecificParameters) {
		this.systemSpecificParameters = systemSpecificParameters;
	}

	public ApplicationSystemParameters getSystemSpecificParameters() {
		return systemSpecificParameters;
	}

	public void setApplicationParameters(UICCApplicationParameters applicationParameters) {
		this.applicationParameters = applicationParameters;
	}

	public UICCApplicationParameters getApplicationParameters() {
		return applicationParameters;
	}

	public void setProcessData(ProcessData processData) {
		this.processData = processData;
	}

	public ProcessData getProcessData() {
		return processData;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {

		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			if (processData != null) {
				codeLength += processData.encode(os, true);
			}
			
			if (applicationParameters != null) {
				codeLength += applicationParameters.encode(os, false);
				// write tag: PRIVATE_CLASS, CONSTRUCTED, 10
				os.write(0xea);
				codeLength += 1;
			}
			
			if (systemSpecificParameters != null) {
				codeLength += systemSpecificParameters.encode(os, false);
				// write tag: PRIVATE_CLASS, CONSTRUCTED, 15
				os.write(0xef);
				codeLength += 1;
			}
			
			codeLength += applicationSpecificParametersC9.encode(os, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 9
			os.write(0xc9);
			codeLength += 1;
			
			if (lifeCycleState != null) {
				codeLength += lifeCycleState.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				os.write(0x83);
				codeLength += 1;
			}
			
			codeLength += applicationPrivileges.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
			
			if (extraditeSecurityDomainAID != null) {
				codeLength += extraditeSecurityDomainAID.encode(os, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 15
				os.write(0x4f);
				codeLength += 1;
			}
			
			codeLength += instanceAID.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			os.write(0x4f);
			codeLength += 1;
			
			codeLength += classAID.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			os.write(0x4f);
			codeLength += 1;
			
			codeLength += applicationLoadPackageAID.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			os.write(0x4f);
			codeLength += 1;
			
			codeLength += BerLength.encodeLength(os, codeLength);
		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();

		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			applicationLoadPackageAID = new ApplicationIdentifier();
			subCodeLength += applicationLoadPackageAID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			classAID = new ApplicationIdentifier();
			subCodeLength += classAID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			instanceAID = new ApplicationIdentifier();
			subCodeLength += instanceAID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			extraditeSecurityDomainAID = new ApplicationIdentifier();
			subCodeLength += extraditeSecurityDomainAID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			applicationPrivileges = new BerOctetString();
			subCodeLength += applicationPrivileges.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			lifeCycleState = new BerOctetString();
			subCodeLength += lifeCycleState.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.PRIMITIVE, 9)) {
			applicationSpecificParametersC9 = new BerOctetString();
			subCodeLength += applicationSpecificParametersC9.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 15)) {
			systemSpecificParameters = new ApplicationSystemParameters();
			subCodeLength += systemSpecificParameters.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			applicationParameters = new UICCApplicationParameters();
			subCodeLength += applicationParameters.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(ProcessData.identifier)) {
			processData = new ProcessData();
			subCodeLength += processData.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("applicationLoadPackageAID: ").append(applicationLoadPackageAID);
		
		sb.append(", ");
		sb.append("classAID: ").append(classAID);
		
		sb.append(", ");
		sb.append("instanceAID: ").append(instanceAID);
		
		if (extraditeSecurityDomainAID != null) {
			sb.append(", ");
			sb.append("extraditeSecurityDomainAID: ").append(extraditeSecurityDomainAID);
		}
		
		sb.append(", ");
		sb.append("applicationPrivileges: ").append(applicationPrivileges);
		
		if (lifeCycleState != null) {
			sb.append(", ");
			sb.append("lifeCycleState: ").append(lifeCycleState);
		}
		
		sb.append(", ");
		sb.append("applicationSpecificParametersC9: ").append(applicationSpecificParametersC9);
		
		if (systemSpecificParameters != null) {
			sb.append(", ");
			sb.append("systemSpecificParameters: ").append(systemSpecificParameters);
		}
		
		if (applicationParameters != null) {
			sb.append(", ");
			sb.append("applicationParameters: ").append(applicationParameters);
		}
		
		if (processData != null) {
			sb.append(", ");
			sb.append("processData: ").append(processData);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

