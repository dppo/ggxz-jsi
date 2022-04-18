import React from "react";
import { Button, Text, View } from "react-native";
import NativeNavigation from "../../jsi_lib/NativeNavigation";
import { name as appName } from "../../app.json";

export default function ScreenOne() {
  return (
    <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
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
    </View>
  );
}
