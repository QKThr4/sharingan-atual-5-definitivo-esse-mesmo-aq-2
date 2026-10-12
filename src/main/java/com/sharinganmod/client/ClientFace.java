package com.sharinganmod.client;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Qual olho aparece no rosto de cada jogador (recebido do servidor). Codigos em FacePayload. */
public final class ClientFace {
    private ClientFace() {}

    private static final Map<UUID, Integer> FACES = new HashMap<>();

    public static void set(UUID id, int code) {
        if (code <= 0) FACES.remove(id);
        else FACES.put(id, code);
    }

    public static int get(UUID id) {
        return FACES.getOrDefault(id, 0);
    }

    /** Layout dos olhos escolhido por cada jogador no proprio rosto: {dx, y, half}. */
    private static final Map<UUID, float[]> LAYOUTS = new HashMap<>();

    public static void setLayout(UUID id, float dx, float y, float half) {
        LAYOUTS.put(id, new float[] {dx, y, half});
    }

    /** Layout do jogador, ou null se ele ainda nao enviou (usa o padrao). */
    public static float[] layout(UUID id) {
        return LAYOUTS.get(id);
    }

    public static void clear() {
        FACES.clear();
        LAYOUTS.clear();
    }
}
