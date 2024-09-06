import axios from 'axios';
import React, { Component } from 'react'

class Weather extends Component {
  

  constructor(props) {
    super(props);
    this.state={
      name:'',
      temp:0,
      temp_max:0,
      temp_main:0,
      humidity:0,
      desc:'',
      icon:'',
      loading:true,
    };
  }

  //위에서 만든 상태 변수에 값을 전달
  componentDidMount(){
    const cityName='Seoul';
    const apiKey=process.env.REACT_APP_WEATHER_KEY;
    const url=`http://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${apiKey}`


  axios
  .get(`http://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${apiKey}`)
  .then((res)=>{
    console.log(res.data)
    const data=res.data
    this.setState({
      name:data.name,
      temp:data.main.temp,
      temp_max:data.main.temp_max,
      temp_min:data.main.temp_min,
      humidity:data.main.humidity,
      desc:data.weather[0].description,
      icon:data.weather[0].icon,
      loading:false,
    })
  })
  .catch((error)=>{console.log(error)})
  }

  render(){
    const {temp,temp_max,temp_min,humidity,desc,icon,loading}=this.state;

    if(loading){
      return <div>Loading ... </div>
    }

    return(
      <div>
        <h1>Weather</h1>
        <p></p>
        <p>현재 온도 : {(temp - 273.15).toFixed(0)}도</p>
        <p>최고 온도 : {(temp_max - 273.15).toFixed(0)}도</p>
        <p>최저 온도 : {(temp_min - 273.15).toFixed(0)}도</p>
        <p>습도 : {humidity}%</p>
        <p>{desc}</p>
        {/* <img src={`http://open.weathermap.org/img/wn/${icon}.png`} alt={desc}></img> */}

      </div>
    ) 
  }


}

export default Weather