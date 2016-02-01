/*
 * Copyright 2016 rohit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.glassfish.mvc.bookstore.security;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rohit
 */
@Stateless
public class LoginBean {

   private String username;
   private String password;
   
   public void setusername(String username){
       this.username=username;
   }
   public void setpassword(String password){
       this.password=password;
   }
   public String getUsername(){
       return this.username;
   }
   public String getPassword(){
       return this.password;
   }
   public String login(){
       FacesContext context = FacesContext.getCurrentInstance();
       HttpServletRequest request =(HttpServletRequest)context.getExternalContext().getRequest();
       try{
           //TODO Need to setup a authentication mechanism. This fails
           request.login(username, password);
       }
       catch(ServletException e){
           context.addMessage(null, new FacesMessage("login failed"));
       }
     return "admin/admin";
   }
}
