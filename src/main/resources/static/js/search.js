let colorArr = ['table-primary','table-success','table-danger'];
var root = '';
				$(document).ready(function(){					
					$.get(root + "/map/sido"
						,function(data, status){
							$.each(data, function(index, vo) {
								$("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
							});
						}
						, "json"
					);
				});
				$(document).on("click", ".aptName", function() {
					var aptName = $(this);
					var aptCode = aptName.parent().children().eq(0).text();
					console.log(aptCode);
					$.get(root + "/deal/apt"
							,{aptCode: aptCode}
							,function(data, status){
								
								$("#searchResult").empty();
								$("#subject").text(aptName.text() + " 매매 실거래가");
								let str = `
											<table class="table">
												<thead>
													<tr>
														<th scope="col">계약일</th>
														<th scope="col">계약 금액</th>
														<th scope="col">면적</th>
														<th scope="col">층</th>
													</tr>
												</thead>
												<tbody>
										`;
								$.each(data, function(index, dto) {
									str += `
										<tr>
											<td>${dto.dealYear}.${dto.dealMonth}.${dto.dealDay}</td>
											<td>${dto.dealAmount}만원</td>
											<td>${dto.area}</td>
											<td>${dto.floor}층</td>
										</tr>
									`;
								});
								str += `</tbody></table>`
								$("#searchResult").append(str);
// displayMarkers(data);
							}
							, "json"
					);
				});
				$(document).on("change", "#sido", function() {
					$.get(root + "/map/gugun"
							,{sido: $("#sido").val()}
							,function(data, status){
								$("#gugun").empty();
								$("#gugun").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#gugun", function() {
					$.get(root + "/map/dong"
							,{gugun: $("#gugun").val()}
							,function(data, status){
								$("#dong").empty();
								$("#dong").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#dong").append("<option value='"+vo.dongCode+"'>"+vo.dongName+"</option>");
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#dong", function() {
					$.get(root + "/map/apt"
							,{dong: $("#dong").val()}
							,function(data, status){
								$("#subject").text($("#dong option:selected").text() + " 매매 실거래가");
								$("#searchResult").empty();
								$.each(data, function(index, vo) {
									let str = `
										<div class="ml-3">
											<div style="visibility:hidden;">${vo.aptCode}</div>
											<div class="aptName">${vo.aptName}</div>
											<div>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</div>
											<div>${vo.buildYear}</div>
											<div style="color:red;">${vo.recentPrice}</div>
										</div>
										<hr align="center" style="width: 80%;">
									`;
									$("#searchResult").append(str);
								});
								displayMarkers(data);
							}
							, "json"
					);
				});
				
				$(document).on("click", "#aptSearchBtn", function() {
					$.get(root + '/map/apt-gugun'
							, {gugun: $("#gugun option:selected").val()}
							, function(data,status) {
								$("#subject").text($("#gugun option:selected").text() + " 매매 실거래가");
								$("#searchResult").empty();
								$.each(data, function(index, vo) {
									let str = `
										<div class="ml-3">
											<div style="display:none;">${vo.aptCode}</div>
											<div class="aptName font-weight-bold">${vo.aptName}</div>
											<div>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</div>
											<div>${vo.buildYear}</div>
											<div style="color:red;">${vo.recentPrice}</div>
										</div>
										<hr align="center" style="width: 80%;">
									`;
									$("#searchResult").append(str);
								});
								displayMarkers(data);
							}
							, "json"
					);
				});
// var param = {
// serviceKey:'ovRRpTm4V9tyurMq45dczHDzcxbbbpRQGwapit%2FXjoueCUAHGQm4Nvvneg0EEVh6cZ9DKLQKpo9i81NwPurhkA%3D%3D',
// pageNo:encodeURIComponent('1'),
// numOfRows:encodeURIComponent('10'),
// LAWD_CD:encodeURIComponent($("#gugun").val()),
// DEAL_YMD:encodeURIComponent('202110')
// };
// $.get('http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev'
// ,param
// ,function(data, status){
// var items = $(data).find('item');
// var jsonArray = new Array();
// items.each(function() {
// var jsonObj = new Object();
// jsonObj.aptCode = $(this).find('일련번호').text();
// jsonObj.aptName = $(this).find('아파트').text();
// jsonObj.dongCode = $(this).find('법정동읍면동코드').text();
// // jsonObj.dongName =
// // $(this).find('').text();
// // jsonObj.sidoName =
// // $(this).find('').text();
// // jsonObj.gugunName =
// // $(this).find('').text();
// jsonObj.buildYear = $(this).find('건축년도').text();
// jsonObj.jibun = $(this).find('지번').text();
// jsonObj.recentPirce = $(this).find('거래금액').text();
//										
// jsonObj = JSON.stringify(jsonObj);
// // String 형태로 파싱한 객체를 다시 json으로 변환
// jsonArray.push(JSON.parse(jsonObj));
// });
// console.log(jsonArray);
// // displayMarkers(jsonArray);
// }
// , "xml"
// );
					/*
					 * var xhr = new XMLHttpRequest(); var url =
					 * 'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev';
					 * var queryParams = '?' + encodeURIComponent('serviceKey') +
					 * '='+encodeURIComponent(' API KEY '); queryParams += '&' +
					 * encodeURIComponent('pageNo') + '=' +
					 * encodeURIComponent('1'); queryParams += '&' +
					 * encodeURIComponent('numOfRows') + '=' +
					 * encodeURIComponent('10'); queryParams += '&' +
					 * encodeURIComponent('LAWD_CD') + '=' +
					 * encodeURIComponent($("#gugun").val()); queryParams += '&' +
					 * encodeURIComponent('DEAL_YMD') + '=' +
					 * encodeURIComponent('202110'); xhr.open('GET', url +
					 * queryParams); xhr.onreadystatechange = function () { if
					 * (this.readyState == 4) { console.log(this.responseXML);
					 * alert('Status: '+this.status+'nHeaders:
					 * '+JSON.stringify(this.getAllResponseHeaders())+'nBody:
					 * '+this.responseText); } };
					 * 
					 * xhr.send('');
					 */
// });
