var psdiv='<div id="adress">'+
						 '<ul>'+
						  '<li>'+
						  '<input data-trigger="peisongdizhi" id="peisongInput" class="input-text address-search" '+
						  'placeholder="智能搜索（支持简拼搜索）" type="text" value=""  autoComplete="off">'+
                       ' <a id="hideAddress" class="link-a hide" href="javascript:void(0);"><i class="icon-address-bg">'+
					  ' </i>隐藏</a>'+
							 ' <div  class="search ps">'+
								  '<ul id="dizhi" >	'+
								  '</ul>'+
							  '</div>'+
						  '</li>'+
						'</ul>'+
					  '</div>';
var jzdiv='<div id="adress2">'+
							' <ul>'+
							 ' <li>'+
                             '<input data-trigger="juzhudizi01"id="peisongInput2" class="input-text address-search" '+
							 'placeholder="智能搜索（支持简拼搜索）" type="text" value="">'+
                            ' <label class="label-check pipei" onclick="pipei()" ><i></i>同配送地址</label>'+
							' <div  class="search jz">'+
								'  <ul id="dizhi2">'+
								'  </ul>'+
							 ' </div>'+
						 ' </li>'+
						'</ul>'+
					 ' </div>';
 var host1=window.location.host;
 $(document).ready(function(){
 $("#psdiv").html(psdiv);
 $("#jzdiv").html(jzdiv);
	var url="http://"+host1+"/address-server/address/getArea";
	$.get(url,{clevel:1},function(data){
		$("#ps01").html(data.data);
		$("#ps01").val("310000000000");
		ps01();});
	$.get(url,{clevel:1},function(data){
		$("#jz01").html(data.data);
		$("#jz01").val("310000000000");
		jz01();});
	//$.get(url,{clevel:2},function(data){$("#ps02").html(data.data);})
	//$.get(url,{clevel:3},function(data){$("#ps03").html(data.data);})
	//$.get(url,{clevel:4},function(data){$("#ps04").html(data.data);})
	//$.get(url,{clevel:5},function(data){$("#ps05").html(data.data);})
	$(".li").click(function(){
	var address=$(this).html();
	$("#peisongInput").val(address);
	$(".search").css({"display":"none"});
	});
	
	$("#peisongInput").focus(function(){
	//$(".ps").css({"display":"block"});
	});
	$("#peisongInput2").focus(function(){
	//$(".jz").css({"display":"block"});
	});
	$("#ps01").change(function(){
		ps01();
	})
	$("#ps02").change(function(){
		ps02();
	})
	$("#ps03").change(function(){
		ps03();
	})
	$("#ps04").change(function(){
		ps04();
	})
	$("#jz01").change(function(){
		jz01();
	})
	$("#jz02").change(function(){
		jz02();
	})
	$("#jz03").change(function(){
		jz03();
	})
	$("#jz04").change(function(){
		jz04();
	})
	$('#peisongInput').bind('input propertychange', function() {  
	loadding("dizhi");
    var address=$(this).val();
	//alert(address);
	url="http://"+host1+"/address-server/address/getJson";
	$.get(url,{address:address},function(data){$(".ps").css({"display":"block"});$("#dizhi").html(data.data);})
	});
	$('#peisongInput2').bind('input propertychange', function() {  
	loadding("dizhi2");
    var address=$(this).val();
	//alert(address);
	url="http://"+host1+"/address-server/address/getJson2";
	$.get(url,{address:address},function(data){$(".jz").css({"display":"block"});$("#dizhi2").html(data.data);})
	});
 })
 function ps01(){
	var cparent=$("#ps01").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:2,cparent:cparent},function(data){
		$("#ps02").html(data.data);
		ps02()})
 }
 function ps02(){
	var cparent=$("#ps02").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:3,cparent:cparent},function(data){
		$("#ps03").html(data.data);
		ps03();})
 }
 function ps03(){
	var cparent=$("#ps03").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:4,cparent:cparent},function(data){
		$("#ps04").html(data.data);
		ps04();})
 }
 function ps04(){
	var cparent=$("#ps04").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:5,cparent:cparent},function(data){
		$("#ps05").html(data.data);})
 }
  function jz01(){
	var cparent=$("#jz01").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:2,cparent:cparent},function(data){$("#jz02").html(data.data);jz02()})
 }
 function jz02(){
	var cparent=$("#jz02").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:3,cparent:cparent},function(data){$("#jz03").html(data.data);jz03()})
 }
 function jz03(){
	var cparent=$("#jz03").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:4,cparent:cparent},function(data){$("#jz04").html(data.data);jz04()})
 }
 function jz04(){
	var cparent=$("#jz04").val();
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$.get(url,{clevel:5,cparent:cparent},function(data){$("#jz05").html(data.data);})
 }

 function select1(code1,code2,code3,code4,code5,road,room,pa_full){
	$("#peisongInput").val(pa_full);
	$("#ps").val(road+room);
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$("#ps01").val(code1);
	$.get(url,{clevel:2,cparent:code1},function(data){$("#ps02").html(data.data);$("#ps02").val(code2);})
	$.get(url,{clevel:3,cparent:code2},function(data){$("#ps03").html(data.data);$("#ps03").val(code3);})
	$.get(url,{clevel:4,cparent:code3},function(data){$("#ps04").html(data.data);$("#ps04").val(code4);})
	$.get(url,{clevel:5,cparent:code4},function(data){$("#ps05").html(data.data);$("#ps05").val(code5);})
	$(".ps").css({"display":"none"});
 }
  function select2(code1,code2,code3,code4,code5,road,room,pa_full){
	$("#peisongInput2").val(pa_full);
	$("#jz").val(road+room);
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$("#jz01").val(code1);
	$.get(url,{clevel:2,cparent:code1},function(data){$("#jz02").html(data.data);$("#jz02").val(code2);})
	$.get(url,{clevel:3,cparent:code2},function(data){$("#jz03").html(data.data);$("#jz03").val(code3);})
	$.get(url,{clevel:4,cparent:code3},function(data){$("#jz04").html(data.data);$("#jz04").val(code4);})
	$.get(url,{clevel:5,cparent:code4},function(data){$("#jz05").html(data.data);$("#jz05").val(code5);})
	$(".jz").css({"display":"none"});
 }
 function loadding(id){
	var loadding='<div style="padding-left:15px">'+
					'<img src="images/loadding2.gif">'+
					'<p style="float:right;margin-right:90px;margin-top:20px">正在加载中...</p>'+
				 '</div>'
	$("#"+id).html(loadding);
 }
 var checked=0;
 function pipei(){
 if(checked==0){
 var code1=$("#ps01").val();
 var code2=$("#ps02").val();
 var code3=$("#ps03").val();
 var code4=$("#ps04").val();
 var code5=$("#ps05").val();
 var jz=$("#ps").val();
	$("#jz").val(jz);
	var url="http://"+host1+"/address-server/address/getAreaByCparent";
	$("#jz01").val(code1);
	$.get(url,{clevel:2,cparent:code1},function(data){$("#jz02").html(data.data);$("#jz02").val(code2);})
	$.get(url,{clevel:3,cparent:code2},function(data){$("#jz03").html(data.data);$("#jz03").val(code3);})
	$.get(url,{clevel:4,cparent:code3},function(data){$("#jz04").html(data.data);$("#jz04").val(code4);})
	$.get(url,{clevel:5,cparent:code4},function(data){$("#jz05").html(data.data);$("#jz05").val(code5);})
	checked=1;
	return;
	}
	if(checked==1){
	checked=0;
	return;
	}
	//$(".pipei").addClass("active");
 }