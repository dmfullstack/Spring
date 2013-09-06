package com.helpezee.validators;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.helpezee.beans.Document;

 @Component
public class  UploadValidator implements Validator {
    private static transient Logger logger = Logger.getLogger(UploadValidator.class);
    // Content types the user can upload
    private static final String[] ACCEPTED_CONTENT_TYPES = new String[] {
            "application/pdf",
            "application/doc",         
            "application/msword",
            "application/rtf",         
            "text/richtext" ,
            "text/rtf" ,
            "text/plain" ,
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document" ,
            "application/vnd.sun.xml.writer" ,
            "application/x-soffice" ,
            };
     
    private static final String[] ACCEPTED_EXTENSIONS = new String[] {
        "doc",
        "pdf",
        "docx",
        "rtf", 
        "txt", 
    };
     
    public boolean supports(final Class clazz) {
    	return Document.class.isAssignableFrom(clazz);
    }
 
    /**
     * Validate our uploaded bean
     */
    @Override
    public void validate(Object obj, Errors errors) {
    	Document uploadItem = (Document) obj;
        //MultipartFile file = uploadItem.;
        try {
            if(uploadItem.getFilename() == null || uploadItem.getContent().length()== 0){
                errors.reject("error.upload.null", "File name can't be empty");
                return;
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
         
        // Check content type
        boolean acceptableContentType = false;
        String incomingContentType = uploadItem.getContentType();
        logger.info("FileName = "+uploadItem.getName());     
        logger.info("incomingContentType = "+incomingContentType);
        // This related to bug  when on Vista and using Firefox content type is 'application/octet-stream'       
        // Instead  of one of the allowed ones
        if("application/octet-stream".equalsIgnoreCase(incomingContentType)){
            int index = uploadItem.getFilename().lastIndexOf('.');
            String incomingExtension = uploadItem.getFilename().substring(index + 1);
            for(String extendsion : ACCEPTED_EXTENSIONS){
                if(extendsion.equalsIgnoreCase(incomingExtension)){
                    acceptableContentType = true;
                    break;
                }          
            }
        }else{
            for(String contentType : ACCEPTED_CONTENT_TYPES){
                logger.debug("Comparing " + incomingContentType +" to "+ contentType);
                if(contentType.equalsIgnoreCase(incomingContentType)){
                    acceptableContentType = true;
                    break;
                }          
            }
        }
        if(!acceptableContentType){
            errors.reject("error.upload.contenttype", "Please upload a file with one of the following file types; .doc, .docx, .txt, .pdf, .rtf .");
        }
    }
}