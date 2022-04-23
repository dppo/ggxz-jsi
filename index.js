/**
 * @format
 */

import { AppRegistry } from "react-native";
import App from "./src/App";
import { name as appName } from "./app.json";
import TestItem from "./src/sreens/TestItem";

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent("TestItem", () => TestItem);
