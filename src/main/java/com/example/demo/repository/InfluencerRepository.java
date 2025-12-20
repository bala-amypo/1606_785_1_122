public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

    Optional<Influencer> findBySocialHandle(String socialHandle);
}
