package example.micronaut

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import java.util.UUID
import javax.validation.Valid

@Controller // <1>
open class BookController {
    @Post // <2>
    @Secured(SecurityRule.IS_ANONYMOUS)
    open fun save(
        @Valid @Body book: Book,
        authentication: Authentication
    ): BookSaved {  // <3>
        val bookSaved = BookSaved()
        bookSaved.name = book.name
        bookSaved.isbn = UUID.randomUUID().toString()
        return bookSaved
    }
}
