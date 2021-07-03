/**
 * @author sunil_s
 * @created on 06/26/2021
 * @description Class containing Initialization of ObjRepoSetup for Android & iOS
 */
package com.swaglabsmobileapp.common;

import java.io.IOException;

import com.swaglabsmobileapp.objectrepo.BaseObjRepo;
import com.swaglabsmobileapp.objectrepo.ObjRepoAndroid;
import com.swaglabsmobileapp.objectrepo.ObjRepoIOS;

public class SetupObjRepo {
	
static BaseObjRepo objRep = null;
	
    public void ObjRepSetupForDevice(String deviceSelectForOR) throws IOException, InterruptedException {
		
    	if(deviceSelectForOR.equalsIgnoreCase("ANDROID")) {
    		//System.out.println("<<< Selecting Object Repository for <Android> device >>> "+ deviceSelectForOR);
			try {
				objRep = new ObjRepoAndroid();
			} catch (Exception e) {
				System.out.println("Catch Block - TestCase: FAIL");
				System.out.println(e.getStackTrace());
				e.printStackTrace();
			}
		} else {
			//System.out.println("<<< Selecting Object Repository for <iOS> device >>> "+ deviceSelectForOR);
			try {
				objRep = new ObjRepoIOS();
			} catch (Exception e) {
				System.out.println("Catch Block - TestCase: FAIL");
				System.out.println(e.getStackTrace());
				e.printStackTrace();
			}
		}
	}
    
    public BaseObjRepo getbaseobjrep() {
    	return objRep;
    }

}
