package com.helpezee.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.helpezee.dao.DocumentDAO;
import com.helpezee.validators.UploadValidator;
import com.helpezee.beans.Document;
import com.helpezee.beans.FileUploadForm;
 
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class DocumentController {
	
	
     
    @Autowired
    private DocumentDAO documentDao;
    
    @Autowired
    public UploadValidator uploadValidator;
     
      
    @RequestMapping("/uploadfile.html" )
    public ModelAndView index(Map<String, Object> map) {
        try {
            map.put("document", new Document());
            map.put("documentList", documentDao.list());
        }catch(Exception e) {
            e.printStackTrace();
        }
 
        return new ModelAndView("documents");
    }
 
    @RequestMapping(value = "/docsave.html", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("document") Document document, BindingResult result,
            @RequestParam("file") MultipartFile file,ModelMap map) {
         
        uploadValidator.validate(document,result);
        System.out.println("Name:" + document.getName());
        System.out.println("Desc:" + document.getDescription());
        System.out.println("File:" + file.getName());
        System.out.println("ContentType:" + file.getContentType());
         
        try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
 
            document.setFilename(file.getOriginalFilename());
            document.setContent(blob);
            document.setContentType(file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            documentDao.save(document);
            map.put("document", new Document());
            map.put("documentList", documentDao.list());
        } catch(Exception e) {
            e.printStackTrace();
        }
         
        return  new ModelAndView("documents");
    }
 
    @RequestMapping("/docdownload.html")
    public ModelAndView download(@RequestParam("documentId")
            Integer documentId,HttpServletRequest request, HttpServletResponse response) {
         
        Document doc = documentDao.get(documentId);
        try {
            //response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
        	response.setHeader("Content-Disposition","attachment");
            OutputStream out = response.getOutputStream();
            response.setContentType(doc.getContentType());
            IOUtils.copy(doc.getContent().getBinaryStream(), out);
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
       return new ModelAndView("documents");
    }
 
    @RequestMapping("/docremove.html")
    public ModelAndView remove(@RequestParam("documentId")Integer documentId,Map<String, Object> map) {
         
        documentDao.remove(documentId);
        map.put("document", new Document());
        map.put("documentList", documentDao.list());
        return new ModelAndView("documents");
    }
    
    
    @RequestMapping(value = "/multifileshow", method = RequestMethod.GET)
    public ModelAndView displayForm() {
    	return  new ModelAndView("fileuploadform");
    }
     
    @RequestMapping(value = "/multifilesave", method = RequestMethod.POST)
    public ModelAndView save(
            @ModelAttribute("uploadForm") FileUploadForm uploadForm,Model map) {
         
        List<MultipartFile> files = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
         
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()
 
            }
        }
         
        map.addAttribute("files", fileNames);
        return new ModelAndView("fileuploadsuccess",(Map)map);
    }

}