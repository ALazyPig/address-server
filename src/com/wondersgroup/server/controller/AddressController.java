package com.wondersgroup.server.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.server.service.IAddressService;

@Controller
@RequestMapping("/address")
@Scope("prototype") 
public class AddressController {

	@Autowired private IAddressService service;
	
	@RequestMapping(value = "/getJson", method = RequestMethod.GET)
	@ResponseBody
	public Object getJson(Model model,HttpServletResponse response,String address){
		response.setHeader("Access-Control-Allow-Origin","*"); 
		List<Map<String,Object>> list;
		if(address.matches("^[A-Za-z0-9]+$")){
			address=address.toUpperCase();
			StringBuffer str=new StringBuffer();
			String[] strs=address.split("");
			for(int i=1;i<strs.length;i++){
				str.append("%"+strs[i]);
			}
			str.append("%");
			address=str.toString();
			list=service.getAddressByZm(address);
			System.out.println(address);
		}else{
			StringBuffer str=new StringBuffer();
			String[] strs=address.split("");
			for(int i=1;i<strs.length;i++){
				str.append("%"+strs[i]);
				
			}
			str.append("%");
			address=str.toString();
			list=service.getAddressByZfc(address);
		}
		 StringBuffer data=new StringBuffer();
		if(list.size()==0){
			data.append("<div style=\"padding-left:20px;padding-top:5px;margin-top:3px\" onclick=\"$('.search').hide()\">");
		//	data.append("<img style=\"width:18px;height:18px\" src=\"../images/icon-close.png\">");
			data.append("<p style=\"float:right;margin-right:90px;margin-top:0px\">没有适配到地址  !!</p>");
			data.append("</div>");
			model.addAttribute("data", data);
			return model;
		}
		
		for(int i=0;i<list.size();i++){
			data.append("<li onclick=\"select1('"+list.get(i).get("PA_PROVINCE_CODE")+"','"+list.get(i).get("PA_CITY_CODE")+"','"+list.get(i).get("PA_DISTRICT_CODE")+"','"+list.get(i).get("PA_TOWN_CODE")+"','"+list.get(i).get("PA_VILLAGE_CODE")+"','"+list.get(i).get("PA_ROAD")+"','"+list.get(i).get("PA_ROOM")+"','"+list.get(i).get("PA_FULL")+"')\" class=\"li\">"+list.get(i).get("PA_FULL")+"</li>");
		}
		model.addAttribute("data", data);
		return model;
	}
	@RequestMapping(value = "/getJson2", method = RequestMethod.GET)
	@ResponseBody
	public Object getJson2(Model model,HttpServletResponse response,String address){
		response.setHeader("Access-Control-Allow-Origin","*"); 
		List<Map<String,Object>> list;
		if(address.matches("^[A-Za-z0-9]+$")){
			address=address.toUpperCase();
			StringBuffer str=new StringBuffer();
			String[] strs=address.split("");
			for(int i=1;i<strs.length;i++){
				str.append("%"+strs[i]);
			}
			str.append("%");
			address=str.toString();
			list=service.getAddressByZm(address);
			System.out.println(address);
		}else{
			StringBuffer str=new StringBuffer();
			String[] strs=address.split("");
			for(int i=1;i<strs.length;i++){
				str.append("%"+strs[i]);
				
			}
			str.append("%");
			address=str.toString();
			list=service.getAddressByZfc(address);
		}
		 StringBuffer data=new StringBuffer();
		if(list.size()==0){
			data.append("<div style=\"padding-left:20px;padding-top:5px;margin-top:3px\" onclick=\"$('.search').hide()\">");
		//	data.append("<img style=\"width:18px;height:18px\" src=\"../images/icon-close.png\">");
			data.append("<p style=\"float:right;margin-right:90px;margin-top:0px\">没有适配到地址  !!</p>");
			data.append("</div>");
			model.addAttribute("data", data);
			return model;
		}
		
		for(int i=0;i<list.size();i++){
			data.append("<li onclick=\"select2('"+list.get(i).get("PA_PROVINCE_CODE")+"','"+list.get(i).get("PA_CITY_CODE")+"','"+list.get(i).get("PA_DISTRICT_CODE")+"','"+list.get(i).get("PA_TOWN_CODE")+"','"+list.get(i).get("PA_VILLAGE_CODE")+"','"+list.get(i).get("PA_ROAD")+"','"+list.get(i).get("PA_ROOM")+"','"+list.get(i).get("PA_FULL")+"')\" class=\"li\">"+list.get(i).get("PA_FULL")+"</li>");
		}
		model.addAttribute("data", data);
		return model;
	}
	@RequestMapping(value = "/getArea", method = RequestMethod.GET)
	@ResponseBody
	public Object getArea(Model model,HttpServletResponse response,String clevel){
	    List<Map<String,Object>> list=service.getArea(clevel);
	    StringBuffer data=new StringBuffer();
		for(int i=0;i<list.size();i++){
		data.append("<option value=\""+list.get(i).get("CCODE")+"\">"+list.get(i).get("CNAME")+"</option>");
		}
		response.setHeader("Access-Control-Allow-Origin","*"); 
		model.addAttribute("data", data);
		return model;
	}
	@RequestMapping(value = "/getAreaByCparent", method = RequestMethod.GET)
	@ResponseBody
	public Object getAreaByCparent(Model model,HttpServletResponse response,String clevel,String cparent){
	    List<Map<String,Object>> list=service.getAreaByCparent(clevel,cparent);
	    StringBuffer data=new StringBuffer();
		for(int i=0;i<list.size();i++){
		data.append("<option value=\""+list.get(i).get("CCODE")+"\">"+list.get(i).get("CNAME")+"</option>");
		}
		response.setHeader("Access-Control-Allow-Origin","*"); 
		model.addAttribute("data", data);
		return model;
	}
	
	public static void main(String[] args) {
		StringBuffer str=new StringBuffer();
		String address ="黄河路262";
		String[] strs=address.split("");
		for(int i=1;i<strs.length;i++){
			str.append("%"+strs[i]);
			
		}
		str.append("%");
	
	}
}
