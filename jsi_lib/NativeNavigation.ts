import type { TurboModule } from "react-native";
import { TurboModuleRegistry } from "react-native";

export interface Spec extends TurboModule {
  navigate(moduleName: string, params: Object): void;
  goBack(): void;
  popToTop(): void;
}

export default TurboModuleRegistry.getEnforcing<Spec>("NativeNavigation");
