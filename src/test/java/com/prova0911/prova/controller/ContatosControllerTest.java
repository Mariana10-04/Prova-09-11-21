package com.prova0911.prova.controller;


import com.prova0911.prova.service.ContatosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ContatosControllerTest {
    @InjectMocks
    private ContatosController controller;

    @Mock
    private ContatosService service; // clone

    @BeforeEach
    void setUp() {
        BDDMockito.when(service.listAll()).thenReturn(ContatosCreator.createRoomList());

        BDDMockito.when(service.findById(ArgumentMatchers.anyLong()))
                .thenReturn(RoomCreator.createOptionalRoomToBeSaved());

        BDDMockito.when(service.save(ArgumentMatchers.isA(Room.class)))
                .thenReturn(RoomCreator.createRoomToBeSaved());

        BDDMockito.doNothing().when(service).update(ArgumentMatchers.isA(Room.class));

        BDDMockito.doNothing().when(service).delete(ArgumentMatchers.anyLong());

        BDDMockito.when(service.findByRoomNumber(ArgumentMatchers.anyInt()))
                .thenReturn(RoomCreator.createOptionalRoomToBeSaved());
    }

}
