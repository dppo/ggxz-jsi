/**
 * @flow strict-local
 * @format
 */
/* eslint-disable */
// import codegenNativeComponent from "react-native/Libraries/Utilities/codegenNativeComponent";
// import type { ViewProps } from "react-native/Libraries/Components/View/ViewPropTypes";
// import type { HostComponent } from "react-native/Libraries/Renderer/shims/ReactNativeTypes";
// import type {
//   BubblingEventHandler,
//   Int32,
// } from "react-native/Libraries/Types/CodegenTypes";

// type ScreenEvent = $ReadOnly<{|
//   offset_y: Int32,
// |}>;

// export type NativeProps = $ReadOnly<{|
//   ...ViewProps,
//   onScroll?: ?BubblingEventHandler<ScreenEvent>,
// |}>;

// type ComponentType = HostComponent<NativeProps>;

// export default (codegenNativeComponent<NativeProps>(
//   "NativeListView",
//   {}
// ): ComponentType);

import type { ViewProps, HostComponent } from "react-native";
import codegenNativeComponent from "react-native/Libraries/Utilities/codegenNativeComponent";

interface NativeProps extends ViewProps {}

export type NativeListViewType = HostComponent<NativeProps>;

export default codegenNativeComponent<NativeProps>("NativeListView");
