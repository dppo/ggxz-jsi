import React from "react";
import { Button, Text, View } from "react-native";
import { name as appName } from "../../app.json";
import NativeNavigation from "../../jsi_lib/NativeNavigation";

export default function ScreenThree() {
  return (
    <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
      <Text>ScreenTwo</Text>
      <Button
        title="Jump To ScreenOne"
        onPress={() => {
          NativeNavigation.navigate(appName, {});
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
