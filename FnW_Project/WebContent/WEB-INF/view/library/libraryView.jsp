<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>지도 이동시키기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>
<p>
   <!--  <button onclick="setCenter()">지도 중심좌표 이동시키기</button> 
    <button onclick="panTo()">지도 중심좌표 부드럽게 이동시키기</button>  -->
    <button onclick="panTo1()">kim</button>
    <button onclick="panTo2()">Gee</button>
    <button onclick="panTo3()">hs</button>
    <button onclick="panTo4()">ssin</button>
<%--     ${library[0].x_position } --%>
<%--     ${library[1].x_position } --%>
<%--     ${library[2].x_position } --%>
<%--     ${library[3].x_position } --%>
    
</p>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4ae9a40e6a14e760a32a8f15af0199e0"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

function setCenter() {            
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new daum.maps.LatLng(33.452613, 126.570888);
    
    // 지도 중심을 이동 시킵니다
    map.setCenter(moveLatLon);
}

function panTo1() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new daum.maps.LatLng(${library[0].x_position}, ${library[0].y_position}); 
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
    
    
    var markerPosition  = new daum.maps.LatLng(${library[0].x_position}, ${library[0].y_position}); 

 	// 마커를 생성합니다
 	var marker = new daum.maps.Marker({
    	 position: markerPosition
 	});

 	// 마커가 지도 위에 표시되도록 설정합니다
 	marker.setMap(map);
    
}     

function panTo2() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new daum.maps.LatLng(${library[1].x_position}, ${library[1].y_position});
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
    
    var markerPosition  = new daum.maps.LatLng(${library[1].x_position}, ${library[1].y_position}); 

 	// 마커를 생성합니다
 	var marker = new daum.maps.Marker({
    	 position: markerPosition
 	});

 	// 마커가 지도 위에 표시되도록 설정합니다
 	marker.setMap(map);
}        

function panTo3() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new daum.maps.LatLng(${library[2].x_position}, ${library[2].y_position});
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
    
    var markerPosition  = new daum.maps.LatLng(${library[2].x_position}, ${library[2].y_position}); 

 	// 마커를 생성합니다
 	var marker = new daum.maps.Marker({
    	 position: markerPosition
 	});

 	// 마커가 지도 위에 표시되도록 설정합니다
 	marker.setMap(map);
}        

function panTo4() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new daum.maps.LatLng(${library[3].x_position}, ${library[3].y_position});
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
    
    var markerPosition  = new daum.maps.LatLng(${library[3].x_position}, ${library[3].y_position}); 

 	// 마커를 생성합니다
 	var marker = new daum.maps.Marker({
    	 position: markerPosition
 	});

 	// 마커가 지도 위에 표시되도록 설정합니다
 	marker.setMap(map);
}        
</script>
</body>
</html>