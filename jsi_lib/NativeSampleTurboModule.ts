import type { TurboModule } from "react-native";
import { TurboModuleRegistry } from "react-native";

export interface Spec extends TurboModule {
  syncOne(): number;
  asyncOne(): void;
}

export default TurboModuleRegistry.getEnforcing<Spec>(
  "NativeSampleTurboModule"
);
