import axios from 'axios';
import { StatusBar } from 'expo-status-bar';
import { useEffect, useState } from 'react';
// import * as React from 'react';
import { Alert, Button, ScrollView, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import NetInfo from '@react-native-community/netinfo'
// import { WebView } from 'react-native-webview'
// import React from 'react'


export default function App() {
  const [itemList,setItemList]=useState([])
  // const [data,setData]=useState([])

  // const getData=async()=>{
  //   const response=await axios.get('/item/list');
  //   const data = response.data;
  //   setData(data)

  // }

  useEffect(()=>{
    // getData()
    axios
    .get('http://localhost:8081/item/list')
    .then((res)=>{
      setItemList(res.data)
    })
    .catch((error)=>{console.log(error)})

  },[])

  const customAlert=()=>{
    Alert.alert('')
  }

  return (
    // <WebView source={{uri:'http://expo.dev'}}/>
    <View style={styles.container}>
        <View>
          <Text>TT</Text>
          {/* <Image source={require('./assets/wolf-8089783_1280.png')}/> */}
        </View>
        <View>
          {itemList.length==0
            ?
            (<Text>아이템없음</Text>)
            :
            (itemList.map((item,i)=>{
              <Text key={i}>{item.itemName}</Text>
            }))
          }
          {/* <Text>이거구나</Text> */}
          {/* <Text>이거구나</Text> */}
          {/* <Text>이거구나</Text> */}
          {/* <Text>이거구나</Text> */}
          {/* <Text>저거구나</Text> */}
        </View>
        <View>
          <TouchableOpacity style={styles.textContainer} onPress={customAlert}>
            <Text>터치버튼</Text>
          </TouchableOpacity>
        </View>


        <Button title='버튼' color={'black'} onPress={()=>Alert.alert('뿡')}/>
        

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    alignItems: 'center',
    justifyContent: 'center',
    
  },
  textContainer:{
    backgroundColor:'lightgray'
  }
});
