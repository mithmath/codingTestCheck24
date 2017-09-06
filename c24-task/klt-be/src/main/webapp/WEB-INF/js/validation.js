function validateform(){  
var lastName=document.reg.lastName.value;  
var firstName=document.reg.firstName.value;  
  
if (lastName==null || lastName==""){  
  alert("lastName can't be blank"); 
  document.reg.lastName.style.borderColor = "red";
  return false;  
}else if(firstName==null || firstName==""){  
  alert("firstName can't be blank"); 
  document.reg.firstName.style.borderColor = "red";
  return false;  
  }  
}  