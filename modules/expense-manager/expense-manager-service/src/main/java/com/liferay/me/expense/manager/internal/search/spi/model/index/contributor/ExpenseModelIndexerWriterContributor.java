package com.liferay.me.expense.manager.internal.search.spi.model.index.contributor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.service.ExpenseLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.me.expense.manager.model.Expense",
        service = ModelIndexerWriterContributor.class
)
public class ExpenseModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<Expense> {

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (Expense assignment) -> {
                    Document document =
                            modelIndexerWriterDocumentHelper.getDocument(assignment);
                    batchIndexingActionable.addDocuments(document);
                });
    }
    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                expenseLocalService.getIndexableActionableDynamicQuery());
    }
    @Override
    public long getCompanyId(Expense expense) {
        return expense.getCompanyId();
    }
    @Reference
    protected ExpenseLocalService expenseLocalService;
    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}