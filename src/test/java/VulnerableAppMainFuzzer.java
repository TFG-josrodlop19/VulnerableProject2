package com.example;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

/** Fuzzer generado para la clase VulnerableApp. Objetivo: método main en la línea 9. */
public class VulnerableAppMainFuzzer {

  public static void fuzzerTestOneInput(FuzzedDataProvider dataProvider) {

    // === GENERACIÓN DE PARÁMETROS PARA MÉTODOS ===
    java.lang.String[] args =
        new String[] {dataProvider.consumeString(100), dataProvider.consumeString(100)};

    // === CREACIÓN DE LA INSTANCIA ===

    // === LLAMADA AL MÉTODO O CONSTRUCTOR OBJETIVO ===
    try {
      VulnerableApp.main(args);
    } catch (Exception e) {
      // Ignorar excepciones esperadas
    }
  }
}
