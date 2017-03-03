<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>postion</title>
  </head>
     <script type="text/javascript">
         function onload(){
           var position = "${Position}";
           var tableElement = document.getElementById("tableID");
           var trElements = document.getElementsByTagName("tr");
           var rows = tableElement.rows.length;
           for(var i=0;i<rows;i++){
              var tdElements = trElements[i].childNodes;
               var size =tdElements.length;
               for(var j=0;j<size;j++){
                   var tdText = tdElements[j].innerHTML;
                   if(position==tdText){
                       tdElements[j].className="position";
                   }
               } 
              
           }
            
         }
       
     </script>
     <style type="text/css">
         .position{
            color:red;
            font-size:44;
         }
     </style>
  <body onload="onload()">
      <table border="1" align="center" width="80%" id="tableID">
        <caption>装备位置</caption>
          <tr>
            <td>1</td>         
            <td>2</td>         
            <td>3</td>         
            <td>4</td>         
            <td>5</td>         
          </tr>
          <tr>
            <td>6</td>         
            <td>7</td>         
            <td>8</td>         
            <td>9</td>         
            <td>10</td>         
          </tr>
          <tr>
            <td>11</td>         
            <td>12</td>         
            <td>13</td>         
            <td>15</td>         
            <td>16</td>         
          </tr>
          <tr>
            <td>17</td>         
            <td>18</td>         
            <td>19</td>         
            <td>20</td>         
            <td>21</td>         
          </tr>
          <tr>
            <td>22</td>         
            <td>23</td>         
            <td>24</td>         
            <td>25</td>         
            <td>26</td>         
          </tr>
          <tr>
            <td>27</td>         
            <td>28</td>         
            <td>29</td>         
            <td>30</td>         
            <td>31</td>         
          </tr>
         <tr>
            <td colspan="5" align="center">
              <jsp:include page="back.jsp"/>
            </td>
         </tr>
      </table>
  </body>
</html>
