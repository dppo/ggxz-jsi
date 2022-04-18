import React from "react";
import { Button, FlatList, Text, View } from "react-native";
import NativeNavigation from "../../jsi_lib/NativeNavigation";
import { name as appName } from "../../app.json";

export default function ScreenTwo() {
  let data = [];
  for (let index = 0; index < 500; index++) {
    data.push(index);
  }
  return (
    <View style={{ flex: 1, justifyContent: "center", paddingTop: 64 }}>
      <Text style={{ alignSelf: "center" }}>ScreenTwo</Text>
      <Button
        title="Jump To ScreenThree"
        onPress={() => {
          NativeNavigation.navigate(appName, {
            screenName: "ScreenThree",
            id: "3",
            name: "3",
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
      <FlatList
        style={{ flex: 1 }}
        data={data}
        renderItem={(rowData) => {
          return (
            <View
              style={{
                height: 44,
                justifyContent: "center",
                alignItems: "center",
              }}
            >
              <Text style={{ fontSize: 16, color: "red" }}>{rowData.item}</Text>
            </View>
          );
        }}
      />
    </View>
  );
}
