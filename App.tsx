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
import NativeSampleTurboModule from "./jsi_lib/NativeSampleTurboModule";
import NativeSampleFabricView, {
  NativeSampleFabricViewType,
  Commands as AnswerViewerCommands,
} from "./jsi_lib/NativeSampleFabricView";

const App = () => {
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
