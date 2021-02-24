package cs.mad.flashcards.entities

//Guess I add this to make lowercase flashcard val?
data class WebFlashcards(val flashcard: List<Flashcard>)

@Entity
data class Flashcard(@PrimaryKey(autoGenerate = true) val myId: Long?, val question: String, val answer: String)

//This is different from the video. Just created to get rid of error
annotation class PrimaryKey(val autoGenerate: Boolean)

//This is different from the video
annotation class Entity

//Maybe the underline problems will disappear along the way.
//Found that val got shifted
fun getHardcodedFlashcards(): List<Flashcard> {
    return listOf(Flashcard("Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
        Flashcard( "Term 1", "Def 1"),
    )
}

//Again everything is red. This time will not change.
@Dao
interface FlashcardDao {
    //Should be (value:"code code code")
    @Query(select * from flashcard order by lower(question) asc)
    suspend fun getAll(): List<Flashcard>
    //Not sure which variables go where?
    @Query(delete from flashcard where answer NOTNULL)
    suspend fun deleteFromWeb()

    @Insert
    suspend fun insert(vararg flashcard: Flashcard)

    @Insert
    suspend fun insert(flashcard: List<Flashcard>)

    @Update
    suspend fun update(flashcard: Flashcard)

    @Delete
    suspend fun delete(flashcard: Flashcard)
}