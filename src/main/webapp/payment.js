
var path="http://3.19.32.109:8080/varsha";
//var path="http://localhost:8080/PG";
 function toaster(){
   document.getElementById("hide").style.display="none";
   }
function disp(){
        document.getElementById("open").style.display="block";
        //document.getElementById("open").className = "modal-open";
        document.getElementById("datahid").style.display="none";
        }
            async function load() {
                const response = await fetch(`${path}/payment`)
            let data = await response.json();
            let i=0;
            let c=document.createElement("tr");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            var td5 = document.createElement("td");
            var txt="";
             for(i=0;i<data.length;i++){
                c=document.createElement("tr");
                td1 = document.createElement("td");
                td2 = document.createElement("td");
                td3 = document.createElement("td");
                td4 = document.createElement("td");
                td5 = document.createElement("td");
                txt="";
                 txt =data[i]['roomNo'];
                 td1.innerHTML=txt;
                 txt="";
                 txt =data[i]['floorNo'];
                 td2.innerHTML=txt;
                 txt="";
                 txt =data[i]['bedNo'];
                 td3.innerHTML=txt;
                 txt="";
                 txt =data[i]['month'];
                 td4.innerHTML=txt;
                 txt="";
                 txt =data[i]['year'];
                 td5.innerHTML=txt;

                  c.appendChild(td1);
                  c.appendChild(td2);
                  c.appendChild(td3);
                  c.appendChild(td4);
                  c.appendChild(td5);
                 //console.log(txt);
                 document.getElementById("tdata").appendChild(c);
             }
            console.log(data);
            }
<!--            function btnclk(){-->


async function btnclk(){
  var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};
if(document.getElementById("roomno").value.length == 0)
              {
               alert("Enter Room No")
              }
                else if(document.getElementById("floorno").value.length == 0)
                 {
                    alert("Enter Floor No")
                 }
                   else if(document.getElementById("bedno").value.length == 0)
                       {
                        alert("Enter Bed No")
                     }
   else{
document.getElementById("open").style.display="none";
document.getElementById("datahid").style.display="block";
let year  = document.getElementById("year").value;
console.log(year);
let month=document.getElementById("month").value;
console.log(month);
let roomno  = document.getElementById("roomno").value;
console.log("RoomNo"+roomno);
let floorno=document.getElementById("floorno").value;
console.log("floorNo"+floorno);
let bedno=document.getElementById("bedno").value;
console.log("bedNo" +bedno);
const monthId=await fetch(`${path}/month?month=${month}&year=${year}`, requestOptions)
const bedId=await fetch(`${path}/bed?roomNo=${roomno}&floorNo=${floorno}&bedNo=${bedno}`, requestOptions)
<!--console.log("month" +await monthId.json());-->
<!--console.log("bed" +await bedId.json());-->
let m1=await monthId.json();
let b1=await bedId.json();
var requestOptions2 = {
  method: 'POST',
  redirect: 'follow'
};
await fetch(`${path}/payment?bedId=${b1}&monthId=${m1}`,requestOptions2)
  document.getElementById("hide").style.display="block";
}
}

<!--  .then(response => response.text())-->
<!--  .then(result =>)-->
<!--  .catch(error => console.log('error', error));-->
<!--console.log("monthId"+monthId);-->
<!--console.log("here month year-&#45;&#45;&#45;&#45;");-->
<!--console.log("here room data&#45;&#45;&#45;&#45;");-->




<!--let bedId;-->
<!--fetch(`${path}/PG/bed?roomNo=${roomno}&floorNo=${floorno}&bedNo=${bedno}`, requestOptions)-->
<!--  .then(response => response.text())-->
<!--  .then(result => console.log("bedId"+result))-->
<!--  .catch(error => console.log('error', error));-->

<!--console.log("bedId" +bedId);-->
<!--}-->


<!--  fetch(`${path}/PG/payment?bedId=4&monthId=1", requestOptions`)-->
<!--  .then(response => response.text())-->
<!--  .then(result => console.log(result))-->
<!--  .catch(error => console.log('error', error));-->
<!--            }-->

