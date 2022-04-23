import React from "react";
import { Text, View } from "react-native";

function getRandomInt(max: number) {
  return Math.floor(Math.random() * max);
}

export default function TestItem(props: { item: string }) {
  const index = parseInt(props.item) % 5;
  const randow = getRandomInt(10);
  return (
    <View
      style={{
        // paddingVertical: 10,
        paddingVertical: 10 * randow,
        backgroundColor: ["red", "blue", "yellow", "orange", "gray"][index],
        // marginVertical: 10,
      }}
    >
      <View
        style={{
          height: 100,
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Text style={{ fontSize: 16, color: "black" }}>{props.item}</Text>
      </View>
      {/* <View style={{ height: 20, backgroundColor: "green" }}></View> */}
    </View>
  );
}
