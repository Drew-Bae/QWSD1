package cs.mad.flashcards.database

//Imported to get rid of red underline
//FlashcardSet is still red even after import
import androidx.room.RoomDatabase
import cs.mad.flashcards.entities.Flashcard
import cs.mad.flashcards.entities.FlashcardDao
import cs.mad.flashcards.entities.FlashcardSet
//Error message (A problem occurred evaluating project ':app'.
//> Could not find method kapt() for arguments [androidx.room:room-compiler:2.2.6] on object of type
// org.gradle.api.internal.artifacts.dsl.dependencies.DefaultDependencyHandler.)
//Video froze so unsure if this is correct "Flashcard::FlashcardSet"
//Apparently there is a resource that shows a simpler way to make a Database
//Used Alt + Enter to import Flashcard, but won't work on FlashcardSet
// (I think it suppose to be some class)
//Video pauses at 26:19
@Database(entities = [Flashcard::FlashcardSet], version = 1)
//Had to download the RoomDatabase. Also how do I get rid of red...
abstract class FlashcardDatabase: RoomDatabase() {
    //Is this supppose to be UserDao or the Dao I previously created?
    abstract fun userDao(): FlashcardDao
}
//Does this code go here?

val db = Room.databaseBuilder(
        //Why is this red?
        applicationContext,
        FlashcardDatabase::class.java, "database-name"
).build()

//Also this code? haha
val userDao = db.userDao()
//This was not red when I had the code as userDao.getAll()
val users: List<Flashcard> = FlashcardDao.getAll()

//This will be code from the video this time (maybe better)
//@Database(entities = [Flashcard::FlashcardSet], version = 1)
//abstract class FlashcardDatabase: RoomDatabase() {
//  abstract fun userDao(): FlashcardDao
//
//  companion object (
//      @Volatile
//      private var INSTANCE: FlashcardDatabase? = null
//
//      fun getDatabase(context: Context): FlashcardDatabase {
//          return INSTANCE ?: synchronized(lock:this) {
//              val instance = Room.databaseBuilder(
//                  context.applicationContext,
//                  FlashcardDatabase::class.java,
//                  name:"app_database"
//              ).fallbackToDestructiveMigration().build()
//              INSTANCE = instance
//              instance