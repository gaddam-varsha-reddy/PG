var path="http://3.19.32.109:8080/";

async function load() {
let c1;
      let option11;
      let txt1;
const response11 = await fetch(`${path}varsha/activeuser`)
      let data11 = await response11.json();
      const response12 = await fetch(`${path}varsha/inactiveuser`)
            let data12 = await response12.json();

      c1=document.createElement("div");
            option11 = document.createElement("p");
            console.log("data11"+data11);
            console.log("data12"+data12);
            txt1=data11+data12;
            option11.innerHTML=txt1;
            c1.appendChild(option11);
            document.getElementById("count").append(c1);

                const response = await fetch(`${path}varsha/userdetails`);
            let data = await response.json();
            let i=0;
            var c=document.createElement("div");
            //c.className="grid-item";
            var option1 = document.createElement("p");
            var img = document.createElement("img");


            var txt="";
             for(i=0;i<data.length;i++){
                c=document.createElement("div");
                option1 = document.createElement("p");
            img = document.createElement("img");
            img.src = `images/${data[i]['firstName']}.jpg`;
            img.classList.add('img');
             c.appendChild(img);

                 txt="";
                 txt =data[i]['firstName'] + " " + data[i]['lastName'];
                 option1.innerHTML=txt;
                 c.appendChild(option1);
                 option2 = document.createElement("p");
                 txt="";
                 txt=data[i]['email'];
                 option2.innerHTML=txt;

                 c.appendChild(option2);
                 if(data[i]['isActive']==false){
                    c.classList.add('addColor')
                 }
                 c.classList.add("image");
                document.getElementById("grid").append(c);
             }
            console.log(data);
            }
