/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, { useRef } from "react";
import {
  Button,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  useColorScheme,
  View,
} from "react-native";
import { Colors, Header } from "react-native/Libraries/NewAppScreen";
import NativeSampleTurboModule from "../jsi_lib/NativeSampleTurboModule";
import NativeSampleFabricView, {
  NativeSampleFabricViewType,
  Commands as AnswerViewerCommands,
} from "../jsi_lib/NativeSampleFabricView";
import NativeNavigation from "../jsi_lib/NativeNavigation";
import { name as appName } from "../app.json";
import ScreenOne from "./sreens/ScreenOne";
import ScreenTwo from "./sreens/ScreenTwo";
import ScreenThree from "./sreens/ScreenThree";

const App = (props: { screenName: string }) => {
  // console.log("initialProps = ", props);
  const { screenName } = props;
  if (screenName == "ScreenOne") {
    return <ScreenOne />;
  } else if (screenName == "ScreenTwo") {
    return <ScreenTwo />;
  } else if (screenName == "ScreenThree") {
    return <ScreenThree />;
  }

  const isDarkMode = useColorScheme() === "dark";

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  const ref = useRef<React.ElementRef<NativeSampleFabricViewType> | null>(null);

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? "light-content" : "dark-content"} />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}
      >
        <Header />
        <View
          style={{
            backgroundColor: isDarkMode ? Colors.black : Colors.white,
          }}
        >
          <NativeSampleFabricView
            ref={ref}
            style={{ backgroundColor: "red", height: 30 }}
            step={222}
            color="white"
          />
          <Button
            title="syncOne"
            onPress={() => {
              NativeSampleTurboModule.asyncOne();
            }}
          />
          <Button
            title="asyncOne"
            onPress={() => {
              const startTime = new Date().getTime();
              const res = NativeSampleTurboModule.syncOne();
              const endTime = new Date().getTime();
              console.log("interval = ", endTime - startTime);
              console.log("res = ", res);
            }}
          />
          <Button
            title="changeBackgroundColor"
            onPress={() => {
              ref.current &&
                AnswerViewerCommands.changeBackgroundColor(ref.current, "blue");
            }}
          />
          <Button
            title="Push"
            onPress={() => {
              NativeNavigation.navigate(appName, {
                screenName: "ScreenOne",
                id: "1",
                name: "1",
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
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: "600",
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: "400",
  },
  highlight: {
    fontWeight: "700",
  },
});

export default App;
