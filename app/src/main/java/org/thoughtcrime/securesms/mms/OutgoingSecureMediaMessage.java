package org.thoughtcrime.securesms.mms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.thoughtcrime.securesms.attachments.Attachment;
import org.thoughtcrime.securesms.contactshare.Contact;
import org.thoughtcrime.securesms.database.model.Mention;
import org.thoughtcrime.securesms.database.model.MessageId;
import org.thoughtcrime.securesms.linkpreview.LinkPreview;
import org.thoughtcrime.securesms.recipients.Recipient;

import java.util.Collections;
import java.util.List;

public class OutgoingSecureMediaMessage extends OutgoingMediaMessage {

  public OutgoingSecureMediaMessage(Recipient recipient,
                                    String body,
                                    List<Attachment> attachments,
                                    long sentTimeMillis,
                                    int distributionType,
                                    long expiresIn,
                                    boolean viewOnce,
                                    boolean isStory,
                                    @Nullable MessageId parentStoryId,
                                    @Nullable QuoteModel quote,
                                    @NonNull List<Contact> contacts,
                                    @NonNull List<LinkPreview> previews,
                                    @NonNull List<Mention> mentions)
  {
    super(recipient, body, attachments, sentTimeMillis, -1, expiresIn, viewOnce, distributionType, isStory, parentStoryId, quote, contacts, previews, mentions, Collections.emptySet(), Collections.emptySet());
  }

  public OutgoingSecureMediaMessage(OutgoingMediaMessage base) {
    super(base);
  }

  @Override
  public boolean isSecure() {
    return true;
  }

  @Override
  public @NonNull OutgoingMediaMessage withExpiry(long expiresIn) {
    return new OutgoingSecureMediaMessage(getRecipient(),
                                          getBody(),
                                          getAttachments(),
                                          getSentTimeMillis(),
                                          getDistributionType(),
                                          expiresIn,
                                          isViewOnce(),
                                          isStory(),
                                          getParentStoryId(),
                                          getOutgoingQuote(),
                                          getSharedContacts(),
                                          getLinkPreviews(),
                                          getMentions());
  }
}
