package com.alexshegstad.footballsimulator.multiplayer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiplayerClientTest {

    @Test
    @DisplayName("MultiplayerClient class should be instantiable")
    void multiplayer_client_should_be_instantiable() {
        MultiplayerClient client = new MultiplayerClient();
        assertThat(client).isNotNull();
    }

    @Test
    @Disabled("Pending full implementation of MultiplayerClient")
    @DisplayName("Client should connect to a running server")
    void client_should_connect_to_server() {
        // Placeholder: test client connection logic
        // once MultiplayerClient is implemented.
    }

    @Test
    @Disabled("Pending full implementation of MultiplayerClient")
    @DisplayName("Client should receive and apply game state updates")
    void client_should_receive_game_state_updates() {
        // Placeholder: verify the client can receive and process server messages.
    }
}
