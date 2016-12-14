<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript">
      function login(){
			var data = "loginname="+encodeURI($("#loginname").val())+"&pwd="+encodeURI($("#pwd").val());
			$.post("http://localhost:8087/coreFrame/loginin",data,function(json){
				alert(json.msg);
			},'json');
      
      }
      
      </script>
<div>
	 loginname:<input id="loginname" name="loginname" type="text" />
	 pwd:<input id="pwd" name="pwd"  type="password" />
	 <input type="button" onClick="login()" value="login" />
</div>

