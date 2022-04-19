import React from "react";
import { Button, Text, View } from "react-native";
import NativeNavigation from "../../jsi_lib/NativeNavigation";
import { name as appName } from "../../app.json";
import NativeListView from "../../jsi_lib/NativeListView";

export default function ScreenOne() {
  return (
    <View style={{ flex: 1 }}>
      <Text>ScreenOne</Text>
      <Button
        title="Jump To ScreenTwo"
        onPress={() => {
          NativeNavigation.navigate(appName, {
            screenName: "ScreenTwo",
            id: "2",
            name: "2",
          });
        }}
      />
      <Button
        title="goBack"
        onPress={() => {
          NativeNavigation.goBack();
        }}
      />
      <Button
        title="popToTop"
        onPress={() => {
          NativeNavigation.popToTop();
        }}
      />
      <NativeListView
        style={{ flex: 1, backgroundColor: "red" }}
        onScroll={(event: any) => {
          // const startTime = event.nativeEvent.timeStamp;
          // const endTime = new Date().getTime();
          // console.log("interval = ", endTime - startTime);
          console.log("onScroll = ", event.nativeEvent.offset_y);
        }}
      />
    </View>
  );
}
