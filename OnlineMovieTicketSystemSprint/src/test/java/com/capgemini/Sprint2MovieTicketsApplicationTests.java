package com.capgemini;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.sprint.dao.AccountDao;
import com.cg.sprint.dao.CityDao;
import com.cg.sprint.dao.LanguagesDao;
import com.cg.sprint.dao.MoviesDao;
import com.cg.sprint.dao.PaymentDao;
import com.cg.sprint.dao.SeatsDao;
import com.cg.sprint.dao.ShowsDao;
import com.cg.sprint.dao.TheatreDao;
import com.cg.sprint.entity.Account;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Languages;
import com.cg.sprint.entity.Movies;
import com.cg.sprint.entity.Payments;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.service.AdminService;
import com.cg.sprint.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
public class Sprint2MovieTicketsApplicationTests {
@Rule
public VerificationCollector verificationCollector = MockitoJUnit.collector();
@Mock
    private CityDao cityDao;
@InjectMocks
private AdminService adminService;
@Before
public void setup(){
MockitoAnnotations.initMocks(this);
}
@Test
public void testGetCityList(){
List<City> cityList = new ArrayList<City>();
cityList.add(new City(11,101,"hyderabad"));
cityList.add(new City(21,102,"pune"));
when(cityDao.findAll()).thenReturn(cityList);
List<City> result = cityDao.getCityList();
assertEquals(2, cityList.size());
}
@Test
public void testaddCity() {
City city=new City(12, 112, "malkajgiri");
city.setSno(12);
city.setCityId(112);
city.setCityNames("malkajgiri");
cityDao.save(city);
}
@Test
public void updateCity() {
City city = new City(11,26,"mvrmall");
cityDao.findById(11);
cityDao.save(city);
  verify(cityDao, Mockito.times(1)).save(city);
}
@Test
public void deleteCity(){
City city = new City(2,23,"hyderabad");
cityDao.deleteById(2);
verify(cityDao, times(1)).deleteById(2);
}
@Mock
private MoviesDao movieDao;
@InjectMocks
private AdminService adminService1;
private Optional<Movies> Movies;
@Before
public void setup1(){
MockitoAnnotations.initMocks(this);
}
@Test
public void testGetMovieList(){
List<Movies> MovieList = new ArrayList<Movies>();
MovieList.add(new Movies(11,"mvrmall","hyderabad"));
MovieList.add(new Movies(21,"balaji","pune"));
when(movieDao.findAll()).thenReturn(MovieList);
List<Movies> result = movieDao.getMovieList();
assertEquals(2, MovieList.size());
}
@Test
public void testaddMovie() {
Movies movie=new Movies(12,"balaji","malkajgiri");
movie.setMovieId(12);
movie.setTheatres("balaji");
movie.setMovie("malkajgiri");
movieDao.save(movie);
}
@Test
public void updateMovies() {
Movies movie = new Movies(65,"grfdestr","mvrmall");
movieDao.findById(65);
movieDao.save(movie);
  verify(movieDao, Mockito.times(1)).save(movie);
}
@Test
public void deleteMovies(){
Movies movies = new Movies(3,"Rajivgandi","hyderabad");
movieDao.deleteById(3);
verify(movieDao, times(1)).deleteById(3);
}
/*@Test
public void testGetMovieById() {
Movies movietest = new Movies(12,"abcd","xyz");
Mockito.when(movieDao.findById(12)).thenReturn(Movies);
Movies result = AdminService.get(12);
assertEquals(12, result.getMovie_id());
assertEquals("abcd", result.getMovies());
assertEquals("xyz", result.getTheatres());
}
@Test
public void testGetMoviesById(){
Movies movie = new Movies(10,"saidhamanu","mvrmall");
when(movieDao.findById(10)).thenReturn(Movies);
Movies result = AdminService.get(10);
assertEquals(10, result.getMovie_id());
assertEquals("mvrmall", result.getTheatres());
assertEquals("saidhamanu", result.getMovies());

}*/

@Mock
private TheatreDao theatreDao;
@InjectMocks
private AdminService adminService2;
@Before
public void setup2(){
MockitoAnnotations.initMocks(this);
}
@Test
public void testGetTheatreList(){
List<Theatre> TheatreList = new ArrayList<Theatre>();
TheatreList.add(new Theatre(11,"srinivasa","siddipet"));
TheatreList.add(new Theatre(24,"asian","pune"));
when(theatreDao.findAll()).thenReturn(TheatreList);
List<Theatre> result = theatreDao.getTheatreList();
assertEquals(2, TheatreList.size());
}
@Test
public void updateTheatre() {
Theatre theatre = new Theatre(35,"grfdestr","mvrmall");
theatreDao.findById(35);
theatreDao.save(theatre);
   verify(theatreDao, Mockito.times(1)).save(theatre);
}

@Test
public void deleteTheatre(){
Theatre theatre = new Theatre(11,"hyderabad","ranam");
theatreDao.deleteById(11);
    verify(theatreDao, times(1)).deleteById(11);
}
@Test
public void testaddTheatre() {
Theatre theatre=new Theatre(18,"qwe","malkajgiri");
theatre.setTheatreId(18);
theatre.setTheatreName("qwe");
theatre.setCityName("malkajgiri");
theatreDao.save(theatre);
}
/*@Test
public void deleteTheatre() {
Theatre theatre = new Theatre(10,"hydearabad","mvrmall");
AdminService.deletetheatre(10);
   verify(theatreDao, times(1)).delete(theatre);
}
public Theatre deleteTheatre() throws Exception {      
    Mockito.when(AdminService.deletetheatre(10)).thenReturn();
    mockMvc.perform(MockMvcRequestBuilders.delete("/theatre", 10))
       .andExpect(status().isOk());
}*/
@Mock
private ShowsDao showsDao;
@InjectMocks
private AdminService adminService3;
@Before
public void setup3(){
MockitoAnnotations.initMocks(this);
}
@Test
public void testGetShowsList(){
List<Shows> showList = new ArrayList<Shows>();
showList.add(new Shows(24,"asian","matniee"));
when(showsDao.findAll()).thenReturn(showList);
List<Shows> result = showsDao.getShowList();
assertEquals(1, showList.size());
}
@Test
public void deleteShows(){
Shows shows = new Shows(2,"Rajivgandi","hyderabad");
showsDao.deleteById(2);
verify(showsDao, times(1)).deleteById(2);
}
@Test
public void updateShows() {
Shows shows = new Shows(25,"grfdestr","mvrmall");
showsDao.findById(25);
showsDao.save(shows);
   verify(showsDao, Mockito.times(1)).save(shows);
}
@Test
public void testaddShows() {
Shows shows=new Shows(12,"", "malkajgiri");
shows.setSno(12);
shows.setTimings("3:40am");
shows.setShow("morning");
showsDao.save(shows);
}
@Mock
private SeatsDao seatsDao;
@InjectMocks
private UserService userService;
@Before
public void setup4(){
MockitoAnnotations.initMocks(this);
}
@Test
public void testGetAllSeats(){
List<Seats> seatList = new ArrayList<Seats>();
seatList.add(new Seats(11,"GOLD",101,32));
//seatList.add(new Seats(21,102,"pune",21,87));
when(seatsDao.findAll()).thenReturn(seatList);
List<Seats> result = seatsDao.findAll();
assertEquals(1,seatList.size());
}
@Test
public void testaddSeats() {
Seats seats=new Seats(12,"gold",112,76);
seats.setSno(12);
seats.setPrice(112);
seats.setSeatType("gold");
seats.setAvailableSeats(76);
seatsDao.save(seats);
}
@Test
public void updateSeats() {
Seats seats = new Seats(25,"GOLD",67,112);
seatsDao.findById(25);
seatsDao.save(seats);
   verify(seatsDao, Mockito.times(1)).save(seats);
}

@Test
public void deleteSeats(){
Seats seats = new Seats(11,"GOLD",101,32);
seatsDao.deleteById(11);
    verify(seatsDao, times(1)).deleteById(11);
}
@Mock
private LanguagesDao languagesDao;
@InjectMocks
private UserService userService1;
@Before
public void setup5(){
MockitoAnnotations.initMocks(this);
}
@Test
public void testGetAllLanguages(){
List<Languages> LanguagesList = new ArrayList<Languages>();
LanguagesList.add(new Languages(11,"telugu"));
//seatList.add(new Seats(21,102,"pune",21,87));
when(languagesDao.findAll()).thenReturn(LanguagesList);
List<Languages> result = languagesDao.findAll();
assertEquals(1,LanguagesList.size());
}
@Test
public void testaddLanguages() {
Languages languages=new Languages(12,"tamil");
languages.setSno(12);
languages.setLanguage("tamil");
languagesDao.save(languages);
}
@Test
public void updateLanguages() {
Languages languages = new Languages(25,"hindi");
languagesDao.findById(25);
languagesDao.save(languages);
   verify(languagesDao, Mockito.times(1)).save(languages);
}

@Test
public void deleteLanguages(){
Languages languages = new Languages(32,"english");
languagesDao.deleteById(32);
    verify(languagesDao, times(1)).deleteById(32);
}
@Mock
private  PaymentDao paymentDao;
@InjectMocks
private AdminService UserService2;
@Before
public void setup6(){
MockitoAnnotations.initMocks(this);
}
/*@Test
public void testGetAllPayments(){
List<Payments> PaymentList = new ArrayList<Payments>();
PaymentList.add(new Payments(11,2,43,67,"hgdf",87,"dgfr"));
//seatList.add(new Seats(21,102,"pune",21,87));
when(paymentDao.findAll()).thenReturn(PaymentList);
List<Payments> result = paymentDao.save(PaymentList);
assertEquals(1,PaymentList.size());}*/
@Test
public void testaddPayments() {
Payments payments=new Payments(12,34,112,65, "malkajgiri",78,"src");
payments.setBookingId(1432);
payments.setAccountNo(76512);
payments.setMoneyCollected(500);
payments.setSeatsBooked(2);
payments.setSeatType("bolcony");
payments.setRefund(250);
paymentDao.save(payments);
}
@Test
public void updatePayment() {
Payments payment=new Payments(29,54,786,12,"sri",87,"opi");
paymentDao.findById(12);
paymentDao.save(payment);
verify(paymentDao, Mockito.times(1)).save(payment);
}
@Test
public void deletePayment(){
Payments payment = new Payments(32,22,11,112,"loan",82,"houseloan");
paymentDao.deleteById(32);
    verify(paymentDao, times(1)).deleteById(32);
}
}
