//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.itmo.Main;
//import ru.itmo.controller.CatController;
//import ru.itmo.controller.CatControllerImpl;
//import ru.itmo.controller.OwnerController;
//import ru.itmo.controller.OwnerControllerImpl;
//import ru.itmo.dao.CatDao;
//import ru.itmo.dao.OwnerDao;
//import ru.itmo.model.*;
//import ru.itmo.service.*;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//        classes = Main.class)
//@AutoConfigureMockMvc
//public class Test1 {
//    @Autowired
//    private MockMvc mockMvc;
//    private CatController catController;
//    private OwnerController ownerController;
//
//    private CatService catService;
//    private OwnerService ownerService;
//    private CatDao catDaoMock;
//    private OwnerDao ownerDaoMock;
//
//    @BeforeEach
//    void setUp() {
//        catDaoMock = mock(CatDao.class);
//        ownerDaoMock = mock(OwnerDao.class);
//        catService = new CatServiceImpl(catDaoMock, ownerDaoMock);
//        ownerService = new OwnerServiceImpl(ownerDaoMock, catDaoMock);
//        catController = new CatControllerImpl(catService);
//        ownerController = new OwnerControllerImpl(ownerService);
//    }
//
//    /**
//     * Test case for creating an owner.
//     */
//    @Test
//    void createOwner() {
//        // Mocking owner data
//        Owner owner = Owner.builder().name("John").birthdate(new Date(2000, 1, 17)).build();
//        when(ownerDaoMock.findById(1)).thenReturn(Optional.ofNullable(owner));
//
//        // Creating owner and retrieving owner info
//        ownerController.createOwner(new OwnerDto("John", new Date(2000, 1, 17),null));
//        String ownerInfo = ownerController.ownerToString(1);
//
//        // Verifying interactions and asserting results
//        verify(ownerDaoMock).findById(1);
//        assertEquals("Name: John Birthdate: Sat Feb 17 00:00:00 MSK 3900 Cats ids: ", ownerInfo);
//    }
//
//    /**
//     * Test case for creating a cat.
//     */
//    @Test
//    void createCat() {
//        // Mocking owner and cat data
//        Owner ownerMock = mock(Owner.class);
//        when(ownerMock.getId()).thenReturn(1);
//        Cat catMock = mock(Cat.class);
//        when(catMock.getName()).thenReturn("Fluf");
//        when(catMock.getBirthdate()).thenReturn(new Date(2020, 1, 17));
//        when(catMock.getColor()).thenReturn(CatColor.SHKIBIDI_DOP_DOP_YES_YES);
//        when(catMock.getBreed()).thenReturn("British Shorthair");
//        when(catMock.getOwner()).thenReturn(ownerMock);
//        when(catMock.getFriends()).thenReturn(new ArrayList<Cat>());
//        when(ownerDaoMock.findById(1)).thenReturn(Optional.of(ownerMock));
//        when(catDaoMock.findById(1)).thenReturn(Optional.of(catMock));
//
//        // Creating cat and retrieving cat info
//        int catId = catController.createCat(new CatDto("Fluf", new Date(2020, 1, 17),"British Shorthair", CatColor.SHKIBIDI_DOP_DOP_YES_YES, 1,null));
//        String catInfo = catController.catToString(1);
//
//        // Verifying interactions and asserting results
//        verify(catDaoMock).findById(1);
//        assertEquals("Name: Fluf Birthdate: Tue Feb 17 00:00:00 MSK 3920 Breed: British Shorthair Color: SHKIBIDI_DOP_DOP_YES_YES OwnerID: 1 Cat friends ids: ", catInfo);
//    }
//}
