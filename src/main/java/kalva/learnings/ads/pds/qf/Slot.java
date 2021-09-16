package kalva.learnings.ads.pds.qf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    private Short remainder;
    private Metadata metadata = new MetadataBitSet();
}
