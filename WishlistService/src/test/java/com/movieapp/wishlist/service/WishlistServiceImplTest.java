/*
 * package com.movieapp.wishlist.service;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertThrows; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
 * 
 * import com.movieapp.wishlist.repository.WishlistRepository;
 * 
 * @ExtendWith(MockitoExtension.class) class WishlistServiceImplTest {
 * 
 * @Mock private WishlistRepository wishlistRepository;
 * 
 * @InjectMocks private WishlistServiceImpl wishlistService;
 * 
 * @Test void testAddMovieWishlist() throws MovieAlreadyWishlistedException {
 * WishListedMovies wishlistMovieToAdd = new WishListedMovies("Movie Title",
 * "username"); when(wishlistRepository.findByTitle("Movie Title",
 * "username")).thenReturn(Optional.empty());
 * when(wishlistRepository.save(wishlistMovieToAdd)).thenReturn(
 * wishlistMovieToAdd);
 * 
 * WishListedMovies addedMovie =
 * wishlistService.addMovieWishlist(wishlistMovieToAdd);
 * 
 * assertEquals(wishlistMovieToAdd, addedMovie); }
 * 
 * @Test void testAddMovieWishlist_MovieAlreadyWishlistedException() {
 * WishListedMovies existingWishlistMovie = new
 * WishListedMovies("Existing Movie", "username");
 * when(wishlistRepository.findByTitle("Existing Movie", "username"))
 * .thenReturn(Optional.of(existingWishlistMovie));
 * 
 * assertThrows(MovieAlreadyWishlistedException.class, () ->
 * wishlistService.addMovieWishlist(existingWishlistMovie)); }
 * 
 * @Test void testRemoveFromWishlist() throws MovieNotFoundInWishlistException {
 * String movieTitleToRemove = "Movie to Remove"; String userName = "username";
 * WishListedMovies wishlistMovieToRemove = new
 * WishListedMovies(movieTitleToRemove, userName);
 * when(wishlistRepository.findByTitle(movieTitleToRemove, userName))
 * .thenReturn(Optional.of(wishlistMovieToRemove));
 * 
 * String result = wishlistService.removeFromWishlist(movieTitleToRemove,
 * userName);
 * 
 * assertEquals("Successfully removed from the wishlist", result);
 * verify(wishlistRepository,
 * times(1)).deleteById(wishlistMovieToRemove.getWishListId()); }
 * 
 * @Test void testRemoveFromWishlist_MovieNotFoundInWishlistException() { String
 * movieTitleNotFound = "Movie Not Found"; String userName = "username";
 * when(wishlistRepository.findByTitle(movieTitleNotFound,
 * userName)).thenReturn(Optional.empty());
 * 
 * assertThrows(MovieNotFoundInWishlistException.class, () ->
 * wishlistService.removeFromWishlist(movieTitleNotFound, userName)); }
 * 
 * @Test void testViewWishlist() { String userName = "username";
 * List<WishListedMovies> wishlistMovies = new ArrayList<>();
 * when(wishlistRepository.findByUserName(userName)).thenReturn(wishlistMovies);
 * 
 * List<WishListedMovies> result = wishlistService.viewWishlist(userName);
 * 
 * assertEquals(wishlistMovies, result); } }
 */