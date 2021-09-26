package com.liferay.me.expense.manager.internal.search.spi.model.index.contributor;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.me.expense.manager.model.Expense;
import java.util.Locale;
import org.osgi.service.component.annotations.Component;
@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.me.expense.manager.model.Expense",
        service = ModelDocumentContributor.class
)
public class ExpenseModelDocumentContributor implements ModelDocumentContributor<Expense>{
    @Override
    public void contribute(Document document, Expense expense) {
        // Strip HTML.
        String description = HtmlUtil.extractText(expense.getDescription());
        document.addText(Field.DESCRIPTION, description);
        String title = HtmlUtil.extractText(expense.getTitle());
        document.addText(Field.TITLE, title);
        document.addDate(Field.MODIFIED_DATE, expense.getModifiedDate());
        // Handle localized fields.
        for (Locale locale : LanguageUtil.getAvailableLocales(
                expense.getGroupId())) {
            String languageId = LocaleUtil.toLanguageId(locale);
            document.addText(
                    LocalizationUtil.getLocalizedName(
            Field.DESCRIPTION, languageId),
            description);
            document.addText(
                    LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
                    title);
        }
    }
}
