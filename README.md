The purpose of this application is to guide a rover 
over a small area defined in the configuration application.properties



<p align="left">
<img src="presentation/KerbalRover.png" width="200" height="200" border="10"/>
</p>
To facilitate this there are 4 main REST API calls:

<table>
<tr>
<th>Method</th>
<th>Api</th>
<th>Description</th>
<th>Payload</th>
<th>Result</th>
</tr>
<tr>
    <td><label class="pill-get">GET</label></td>
    <td>/api/rover/report</td>
    <td> </td>
    <td> </td>
    <td> </td>
</tr>
<tr>
    <td><label class="pill-post">POST</label></td>
    <td>/api/rover/place</td>
    <td> </td>
    <td> </td>
    <td> </td>
</tr>
<tr>
    <td><label class="pill-post">POST</label></td>
    <td>/api/rover/move</td>
    <td> </td>
    <td> </td>
    <td> </td>
</tr>
<tr>
    <td><label class="pill-post">POST</label></td>
    <td>/api/rover/turn</td>
    <td> </td>
    <td> </td>
    <td> </td>
</tr>
</table>

<p align="left">
<img src="presentation/coordinateSystem.PNG" width="400" height="400" border="10"/>
</p>

<p align="left">
<img src="presentation/ballFallOff.PNG" width="200" height="200" border="10"/>
</p>

<p align="left">
<img src="presentation/ballCaptured.PNG" width="200" height="200" border="10"/>
</p>

<style>
.pill-get {
  background-color: #43d738;
  border: none;
  color: black;
  padding: 3px 12px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 16px;
}
.pill-post {
  background-color: #3e63ea;
  border: none;
  color: black;
  padding: 2px 7px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 16px;
}
</style>